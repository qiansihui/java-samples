package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的i值为：" + i);
        }
    }
}
