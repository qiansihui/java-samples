package com.javacore.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author qianqian.sun
 * @Date 2018/3/6
 * 描述：
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return 2;
        });
        Thread threadB = new Thread(future);
        threadB.start();

        int i = future.get();
        System.out.println("A" + i);

    }
}
