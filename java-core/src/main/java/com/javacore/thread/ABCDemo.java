package com.javacore.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qianqian.sun 2018/5/24
 * 描述：
 */
public class ABCDemo {
    private volatile int f = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void printABC() {
        Thread a = new Thread(() -> {
            while (f <= 30) {
                lock.lock();
                if (0 == f % 3) {
                    System.out.println("a");
                    f++;
                }
                lock.unlock();
            }
        });
        Thread b = new Thread(() -> {
            while (f <= 30) {
                lock.lock();
                if (1 == f % 3) {
                    System.out.println("b");
                    f++;
                }
                lock.unlock();
            }
        });
        Thread c = new Thread(() -> {
            while (f <= 30) {
                lock.lock();
                if (2 == f % 3) {
                    System.out.println("c");
                    f++;
                }
                lock.unlock();
            }
        });
        a.start();
        b.start();
        c.start();
    }

    public static void main(String[] args) {
        ABCDemo demo = new ABCDemo();
        demo.printABC();
    }


}
