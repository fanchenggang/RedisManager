package com.redis.manager.util;

import com.redis.manager.config.UserConfig;
import com.redis.manager.model.RedisClient;
import lombok.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: FanChengGang
 * @date: 2019-10-08 14:06
 * @describe: TODO
 **/
public class RedisService {


    public  static Map<String, RedisClient> redisClientMap;


    public static Jedis jedis;

    static {
        redisClientMap = UserConfig.redisClientList.stream().collect(Collectors.toMap(k -> k.getName(), v -> v));
    }

    private static Jedis initJedis(String host,int port,String auth) {
        jedis = new Jedis(host, port);
        String resp = jedis.auth(auth);
        if ("OK".equals(resp)){
            return jedis;
        }
        return jedis;
    }

    public static List<Db> getDbList(String connectName) {
        RedisClient redisClient = redisClientMap.get(connectName);
        if (redisClient == null){
            for (RedisClient client : UserConfig.redisClientList) {
                if (client.getName().equals(connectName)){
                    redisClient = client;
                    redisClientMap.put(connectName,client);
                }
            }
        }
        Jedis jedis = redisClient.getJedis();
        if (jedis==null){
            redisClient.setJedis(initJedis(redisClient.getHost(),redisClient.getPort(),redisClient.getPassword()));
        }
        ArrayList<Db> dbList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            Long count = null;
            try {
                RedisService.jedis.select(i);
                count = RedisService.jedis.dbSize();
            } catch (JedisDataException e) {
                break;
            }
            dbList.add(new Db("db" + i, count));
        }
        return dbList;
    }

    public static void main(String[] args) {


    }

    public static Set<String> getAllKeyList(int db) {
        jedis.select(db);
        return jedis.keys("*");
    }

    public static String getKey(String key) {
        return jedis.get(key);
    }

    public static void closeAll() {
        jedis.close();
    }

    public static String getType(String key) {
        return jedis.type(key);
    }

    public static Long getLength(String key) {
        return jedis.llen(key);
    }

    public static Long ttl(String key){
        return jedis.ttl(key);
    }

    public static Long expire(String key,int seconds){
        Long expire = jedis.expire(key, seconds);
        return expire;
    }

    public static List<String> lrange(String key) {
        return jedis.lrange(key, 0, getLength(key));
    }

    public static void rename(String oldKeyName, String newKeyName) {
        jedis.rename(oldKeyName,newKeyName);
    }

    public static Long delete(String key) {
        Long del = jedis.del(key);
        return del;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Db {
        private String name;
        private Long count;

        public Long getCount() {
            return count == null ? 0 : count;
        }
    }
    //https://www.cnblogs.com/chy18883701161/p/11087482.html
}
