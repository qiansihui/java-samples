package com.javacore.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Author qianqian.sun
 * @Date 2018/3/6
 * 描述：信号量
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "thread" + i);
            thread.start();
        }

    }
}
