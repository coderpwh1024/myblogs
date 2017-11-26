package com.imooc.demo.HelloQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 彭文浩 on 2017/11/14.
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat();
        System.out.println("Current Exec Time Is : " + sf.format(date));

        System.out.println("hello world");
    }
}
