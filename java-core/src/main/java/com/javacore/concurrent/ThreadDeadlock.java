package com.javacore.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author qianqian.sun
 * @Date 2018/3/11
 * 描述：
 */
public class ThreadDeadlock {
    ExecutorService exec = Executors.newCachedThreadPool();

    public void transfer(Account a, Account b) {
        synchronized (a) {
            System.out.println("get " + a.name);
            synchronized (b) {
                System.out.println("get " + b.name);
                a.transfer();
                b.transfer();
            }
        }
    }

    public void transfer(int i) {
        Account a = new Account("A");
        Account b = new Account("B");
        exec.submit(() -> {
            System.out.println("thread-" + i);
            transfer(a, b);
        });
        exec.submit(() -> {
            System.out.println("thread-" + i);
            transfer(b, a);
        });

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDeadlock threadDeadlock = new ThreadDeadlock();
        for (int i = 0; i < 10; i++) {
            threadDeadlock.transfer(i);
        }
        threadDeadlock.exec.shutdown();
        System.out.println("shutdown");
        threadDeadlock.exec.awaitTermination(1, TimeUnit.SECONDS);
    }
}
