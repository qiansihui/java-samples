package com.javacore.object.init;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/16
 * @Description:
 * @CodeReviewer:
 */
public class A {
    public A() {
        System.out.println("A constructor");
    }

    {
        System.out.println("A {}");
    }

    static {
        System.out.println("A static{}");
    }
}
