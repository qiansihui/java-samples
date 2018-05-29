package com.javacore.guava;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author qianqian.sun
 * @Date 2017/12/18
 * 描述：
 */
public class GuavaCache {
    @Test
    public void cache() throws ExecutionException, InterruptedException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .removalListener(new RemovalListener() {
                    @Override
                    public void onRemoval(RemovalNotification removalNotification) {
                        System.out.println("缓存删除key:" + removalNotification.getKey());
                    }
                })
                // 如果有缓存则返回；否则运算、缓存、然后返回
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        if ("sqq".equals(key)) {
                            System.out.println("缓存加载");
                            return "q1";
                        }
                        return "q2";
                    }
                });
        System.out.println("test");
        System.out.println(cache.get("sqq"));
        System.out.println(cache.get("sqq"));
        cache.invalidate("sqq"); // 清除key

    }
}
