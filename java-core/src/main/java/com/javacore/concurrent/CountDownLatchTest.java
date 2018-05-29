package com.javacore.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author qianqian.sun
 * @Date 2018/3/6
 * 描述：闭锁
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Integer[] i = new Integer[1];
        Thread threadA = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A" + i[0]);
        });
        threadA.start();
        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
            i[0] = 2;
            countDownLatch.countDown();
        });
        threadB.start();
    }
}
