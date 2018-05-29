package com.javacore.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @Author qianqian.sun
 * @Date 2018/3/11
 * 描述：
 */
public class TimingThreadPool extends ThreadPoolExecutor {
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final Logger logger = Logger.getLogger("timing-thread-pool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();


    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.info(String.format("Thread %s : start %s", t, r));
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long endTime = System.nanoTime();
        numTasks.incrementAndGet();
        totalTime.addAndGet(endTime - startTime.get());
        super.afterExecute(r, t);
    }

    @Override
    protected void terminated() {
        logger.info(String.format("Terminated: avg time = %dns ", totalTime.get() / numTasks.get()));
        super.terminated();
    }
}
