package com.middleware.quartz;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:
 * @CodeReviewer:
 */
public class TestScheduledExecutor implements Runnable {
    private String jobName = "";

    public TestScheduledExecutor(String jobName) {
        this.jobName = jobName;
    }


    public void run() {
        System.out.println("execute " + jobName);
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        long initiaDelay1 = 1;
        long period1 = 1;
        //从现在开始1秒钟后 每隔1秒钟执行一次job1
        //每次任务开始后推迟1秒执行下个任务
        //基于固定时间间隔进行任务调度
        service.scheduleAtFixedRate(new TestScheduledExecutor("job1"), initiaDelay1, period1, TimeUnit.SECONDS);

        // 每次任务结束后推迟1秒执行下个任务
        // 取决于每次任务执行时间长短，是基于不固定时间间隔进行任务调度
        service.scheduleWithFixedDelay(new TestScheduledExecutor("job2"), initiaDelay1, period1, TimeUnit.SECONDS);


    }
}
