package com.javacore.object;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Singleton {
    //使用一个变量来缓存创建的单例
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
