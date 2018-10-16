package com.wangchg.study.redis.queue;

import com.wangchg.study.redis.util.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class QueueTest {
    @Test
    public void test() {
        Jedis jedis = RedisUtil.create();
        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "q-demo");
        Thread product = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.delay("codehole" + i);
                }
            }
        };
        Thread consumer = new Thread() {
            @Override
            public void run() {
                queue.loop();
            }
        };

        product.start();
        consumer.start();

        try {
            product.join();
            Thread.sleep(5000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
        }
    }
}
