package com.javacore.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author qianqian.sun
 * @Date 2018/3/6
 * 描述：关卡
 */
public class BarrierTest {

    public static void main(String[] args) {
        int count = 3;
        final CyclicBarrier barrier = new CyclicBarrier(count, () -> System.out.println("关卡结束"));
        for (int i = 0; i < count; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000 * finalI);
                    System.out.println(finalI);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "thread" + i);
            thread.start();
        }
    }
}
