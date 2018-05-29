package com.middleware.quartz;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:
 * @CodeReviewer:
 */
public class TestTimer extends TimerTask {

    private String jobName = "";

    public TestTimer(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("execute " + jobName);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay1 = 1 * 1000;
        long period1 = 1000;
        //从现在开始 period1 秒后 ， 每隔 delay1 执行一次job1
        timer.schedule(new TestTimer("job1"), delay1, period1);
    }
}
