package com.coderpwh.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by coderpwh on 2018/1/12.
 */
public class Executors3 {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }



   private static void test1() throws InterruptedException {

       ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
       Runnable task = ()-> System.out.println("Scheduling:"+System.nanoTime());
       int delay = 3;
       ScheduledFuture<?> future = scheduledExecutorService.schedule(task,delay, TimeUnit.SECONDS);
       TimeUnit.MILLISECONDS.sleep(1337);

       long  remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
       System.out.printf("Rmaining Delay: %sms\n",remainingDelay);

    }

}
