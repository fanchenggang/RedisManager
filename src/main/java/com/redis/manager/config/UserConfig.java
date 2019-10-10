package com.redis.manager.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.redis.manager.model.RedisClient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

/**
 * @author: FanChengGang
 * @date: 2019-10-10 10:51
 * @describe: TODO
 **/

public class UserConfig {

    public static List<RedisClient> redisClientList;


    static {
        Help.getUserConfig();
    }


    public static void removeRedisClient(String name) {
        redisClientList = redisClientList.stream().filter(r->r.getName().equals(name)).collect(Collectors.toList());
        Help.putUserConfig();
    }

    public static boolean addRedisClient(RedisClient redisClient){
        for (RedisClient client : redisClientList) {
            if (client.getName().equals(redisClient.getName())){
                return false;
            }
        }
        redisClientList.add(redisClient);
        Help.putUserConfig();
        return true;
    }

    public static void updateRedisClient(RedisClient oldClient,RedisClient newClient){
        for (RedisClient redisClient : redisClientList) {
            if (redisClient.getName().equals(oldClient.getName())){
                redisClient.setName(newClient.getName());
                redisClient.setHost(newClient.getHost());
                redisClient.setPort(newClient.getPort());
                redisClient.setPassword(newClient.getPassword());
            }
        }
        Help.putUserConfig();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static   class Config{
        private  List<RedisClient> redisClientList;
    }



    private static class Help{
       private final static String rootNode = "/com/redisManager";
       private final static String defaultConfig ="{}";

       public static void getUserConfig(){
           Preferences root = Preferences.userRoot();
           Preferences node = root.node(rootNode);
           String configJson = node.get("config", defaultConfig);
           Config config = JSONObject.parseObject(configJson, Config.class);
           redisClientList = Optional.ofNullable(config.getRedisClientList()).orElse(new ArrayList<>());
       }

       public static void putUserConfig(){
           Preferences root = Preferences.userRoot();
           Preferences node = root.node(rootNode);
           Config config =  new Config();
           config.setRedisClientList(redisClientList);
           node.remove(rootNode);
           node.put("config", JSON.toJSONString(config));
        }
   }


    public static void main(String[] args) {

        RedisClient redisClient = new RedisClient("mp-dev","39.107.90.99",6379,"mfljfadfasdfasdf",null);
        RedisClient redisClient2 = new RedisClient("mp-prod","39.107.90.99",6379,"mfljfadfasdfasdf",null);
        redisClientList.clear();
        redisClientList.add(redisClient);
        redisClientList.add(redisClient2);

        Help.putUserConfig();
      //  updateRedisClient(redisClient,redisClient2);
    }

}
