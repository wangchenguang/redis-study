package com.wangchg.study.redis.lock;


import com.wangchg.study.redis.util.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class LockTest {
    @Test
    public void test() {
        Jedis jedis = RedisUtil.create();

        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.unlock("codehole"));
        System.out.println(redis.unlock("codehole"));
    }
}
