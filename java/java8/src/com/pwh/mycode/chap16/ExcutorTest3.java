package com.pwh.mycode.chap16;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author coderpwh
 * @create 2020-03-26 14:44
 * @desc ${DESCRIPTION}
 **/
public class ExcutorTest3 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒");
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟一秒后每三秒执行一次");
            }
        },1, 3, TimeUnit.SECONDS);

    }
}
