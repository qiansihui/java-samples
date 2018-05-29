package com.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //创建一个具有固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //想线程池中提交两个线程
        pool.submit(new TestRunnable());
        pool.submit(new TestRunnable());
        //关闭线程池
        pool.shutdown();
    }
}
