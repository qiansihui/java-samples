package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description: 怎么完全看不到多线程并发执行的样子，难道我电脑太快了？、
 * 原因调用了线程对象的run方法而不是start方法
 * 优点：编写简单
 * 缺点：不可再继承其他类
 * @CodeReviewer:
 */
public class TestThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("通过继承Thread类实现多线程");
        for (; i < 100; i++) {
            System.out.println(getName() + "---" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(currentThread().getName() + i);
            if (i == 20) {
                new TestThread().start();
                new TestThread().start();
                try {
                    Thread.sleep(1);    //让主线程休眠1毫秒 子线程立即执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
