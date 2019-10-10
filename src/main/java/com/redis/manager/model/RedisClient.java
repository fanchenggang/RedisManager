package com.redis.manager.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import redis.clients.jedis.Jedis;

/**
 * @author: FanChengGang
 * @date: 2019-10-10 9:48
 * @describe: TODO
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedisClient {

    private String name;
    private String host;
    private int port;
    private String password;

    private  Jedis jedis;
}
