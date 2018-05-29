package com.javacore.concurrent;

/**
 * @Author qianqian.sun
 * @Date 2018/3/7
 * 描述：
 */
public interface Computable<A, V> {
    V compute(A key);
}
