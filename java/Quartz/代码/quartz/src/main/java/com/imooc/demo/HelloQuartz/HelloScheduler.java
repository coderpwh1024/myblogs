package com.imooc.demo.HelloQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 彭文浩 on 2017/11/26.
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {

        // 当前时间

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is : " + sdf.format(date));

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob").build();

        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?")).build();


        // 创建Scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        System.out.println("scheduled time is :"
                + sdf.format(scheduler.scheduleJob(jobDetail, trigger)));
        //scheduler执行两秒后挂起
        Thread.sleep(2000L);
        //shutdown(true)表示等待所有正在执行的job执行完毕之后，再关闭scheduler
        //shutdown(false)即shutdown()表示直接关闭scheduler
        scheduler.shutdown(false);
        System.out.println("scheduler is shut down? " + scheduler.isShutdown());

    }



}
