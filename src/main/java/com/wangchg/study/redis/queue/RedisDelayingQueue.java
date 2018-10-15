package com.wangchg.study.redis.queue;

import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;

public class RedisDelayingQueue<T> {
    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    private Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();

}
