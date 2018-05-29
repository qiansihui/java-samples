package com.javacore.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author qianqian.sun
 * @Date 2018/3/7
 * 描述：缓存实现
 */
public class Memoizer<A, V> implements Computable<A, V> {
    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;// 计算动作

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }


    @Override
    public V compute(A key) {
        while (true) {
            Future<V> f = cache.get(key);
            if (null == f) {
                FutureTask<V> futureTask = new FutureTask<V>(() -> c.compute(key));
                f = cache.putIfAbsent(key, futureTask);
                if (null == f) {//第一次放入
                    f = futureTask;
                    futureTask.run();
                }
            }
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                cache.remove(key, f);// 计算失败则移除
            }
        }

    }
}
