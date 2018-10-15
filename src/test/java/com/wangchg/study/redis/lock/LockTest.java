package com.wangchg.study.redis.lock;


import org.junit.Test;
import redis.clients.jedis.Jedis;

public class LockTest {
    @Test
    public void test() {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.unlock("codehole"));
        System.out.println(redis.unlock("codehole"));
    }
}
