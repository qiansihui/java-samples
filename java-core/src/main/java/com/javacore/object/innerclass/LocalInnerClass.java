package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        class InnerBase {
            int a;
        }
        class Inner extends InnerBase {
            int b;
        }
        Inner inner = new Inner();
        inner.a = 1;
        inner.b = 2;
        System.out.println("a:" + inner.a + ",b:" + inner.b);

    }
}
