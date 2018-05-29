package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class CreateInnerClass {
    public static void main(String[] args) {
        Out.In in = new Out().new In("test inner");

    }
}

class Out {
    class In {
        public In(String msg) {
            System.out.println(msg);
        }
    }
}
