package com.redis.manager.util;

import lombok.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: FanChengGang
 * @date: 2019-10-08 14:06
 * @describe: TODO
 **/
public class RedisService {

    public static Jedis jedis;

   static {
       initJedis();
   }
    private static Jedis initJedis(){
        jedis = new Jedis("39.107.90.99",6379);
        String resp = jedis.auth("mfljfadfasdfasdf");
        System.out.println(resp);
        return jedis;
    }

    public static List<Db> getDbList(){
        ArrayList<Db> dbList = new ArrayList<>(20);
        for (int i = 0; i < 20 ; i++) {
            Long count = null;
            try {
                jedis.select(i);
                count = jedis.dbSize();
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

    public static String getType(String key){
       return jedis.type(key);
    }

    public static Long getLength(String key){
       return jedis.llen(key);
    }

    public static List<String> lrange(String key){
       return jedis.lrange(key,0,getLength(key));
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
   public static class Db{
        private String name;
        private Long count;

        public Long getCount(){
            return count==null?0:count;
        }
    }
    //https://www.cnblogs.com/chy18883701161/p/11087482.html
}
