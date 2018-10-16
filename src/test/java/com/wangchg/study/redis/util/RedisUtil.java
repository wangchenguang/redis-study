package com.wangchg.study.redis.util;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2018/10/16
 */
public class RedisUtil {
    private static final String KEY_HOST = "redis.host";
    private static final String KEY_PORT = "redis.port";

    public static Jedis create() {
        try {
            InputStream is = RedisUtil.class.getClassLoader().getResourceAsStream("config.properties");
            Properties p = new Properties();
            p.load(is);
            Jedis jedis = new Jedis(p.getProperty(KEY_HOST), Integer.parseInt(p.getProperty(KEY_PORT)));
            return jedis;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

