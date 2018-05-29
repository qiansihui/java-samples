package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestYield extends Thread {
    public TestYield() {
    }

    public TestYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "---" + i);
            if (i == 20) {
                Thread.yield();     //使用yield使线程让步
            }
        }
    }

    public static void main(String[] args) {
        //启动两条并发线程
        TestYield t1 = new TestYield("高级");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        TestYield t2 = new TestYield("低级");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        TestYield t3 = new TestYield("也是高级");
        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();
    }
}
