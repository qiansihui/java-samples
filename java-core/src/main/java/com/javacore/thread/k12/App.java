package com.javacore.thread.k12;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/16
 * @Description:
 * @CodeReviewer:
 */
public class App {
    public static volatile int i = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (i < 500) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + ",i = " + i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (i > -500) {
                    i--;
                    System.out.println(Thread.currentThread().getName() + ",i = " + i);
                }
            }
        }).start();
    }
}
