package com.pwh.mycode.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Created by 彭文浩 on 2018/6/9.
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        // sleepThread 设为守护线程
        sleepThread.setDaemon(true);


        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
         sleepThread.start();
         busyThread.start();

        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        TimeUnit.SECONDS.sleep(2);


    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
//                System.out.println("1111");
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
//                System.out.println("2222");
            }
        }
    }
}
