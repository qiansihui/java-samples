package com.javacore.object;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}
