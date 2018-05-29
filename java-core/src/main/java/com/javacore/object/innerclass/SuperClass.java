package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class SuperClass extends Out.In {

    public SuperClass(Out out) {
        out.super("hello");
    }

    public static void main(String[] args) {
        SuperClass superClass = new SuperClass(new Out());
    }
}
