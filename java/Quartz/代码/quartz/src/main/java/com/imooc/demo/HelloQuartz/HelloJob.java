package com.imooc.demo.HelloQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by 彭文浩 on 2017/11/14.
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("hello world");
    }
}
