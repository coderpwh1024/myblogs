package com.pwh.mycode.chapter04;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by 彭文浩 on 2018/6/9.
 */
public class MultiThread {

    public static void main(String[] args) {


         // threadMxBean java虚拟机线程管理接口
        ThreadMXBean threadMXBean =    ManagementFactory.getThreadMXBean();

         // 线程信息类
        ThreadInfo[] threadInfos =  threadMXBean.dumpAllThreads(false,false);

          for (ThreadInfo threadInfo:threadInfos){
              System.out.println("["+threadInfo.getThreadId()+"] "+threadInfo.getThreadName());
          }

    }
}
