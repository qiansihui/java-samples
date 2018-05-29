package com.javacore.object.init;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/16
 * @Description:
 * @CodeReviewer:
 */
public class B extends A {
    public B() {
        System.out.println("B constructor");
    }

    {
        System.out.println("B {}");
    }

    static {
        System.out.println("B static{}");
    }

    public static void main(String[] args) {
        new B();
    }
}
