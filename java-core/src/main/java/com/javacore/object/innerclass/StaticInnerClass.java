package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        StaticOut.In in = new StaticOut.In();
    }
}

class StaticOut {
    static class In {
        public In() {
            System.out.println("static innner class");
        }
    }

}
