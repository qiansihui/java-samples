package com.middleware.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:如何用 Quartz 实现每星期二 16:38 的调度安排：
 * @CodeReviewer:
 */
public class TestQuartz implements Job {
    //方法实现需要执行的任务
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Generating report - "
                + context.getJobDetail().getDescription() + ", type = "
                + context.getJobDetail().getJobDataMap().get("type"));
        System.out.println(new Date());
    }

    public static void main(String[] args) {
        try {
            // 创建一个 Scheduler
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            // 创建一个 JobDetail 指明 nmae,groupname,以及具体job类名
            //该Job负责定义需要执行的任务
            JobDetail jobDetail = new JobDetail("myjob", "myjobGroup", TestQuartz.class);
            jobDetail.getJobDataMap().put("type", "FULL");

            //创建一个每周触发的 Trigger , 指明星期几几点几分执行
            Trigger trigger = TriggerUtils.makeWeeklyTrigger(3, 16, 38);
            trigger.setGroup("my_trigger_group");

            //从当前时间的下一秒开始执行
            trigger.setStartTime(TriggerUtils.getEvenSecondDate(new Date()));
            trigger.setName("my_trigger");

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
