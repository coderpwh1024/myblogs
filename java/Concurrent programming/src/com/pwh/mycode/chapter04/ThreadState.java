package com.pwh.mycode.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 彭文浩 on 2018/6/9.
 */
public class ThreadState {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

         new Thread(new TimeWaiting(),"TimeWaitingThread").start();
         new Thread(new Waiting(),"WaitingThread").start();

        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
        new Thread(new Sync(), "SyncThread-1").start();
        new Thread(new Sync(), "SyncThread-2").start();

    }


    /**
     * 该类进程处于不断休眠状态
     */

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }


    /**
     *  处于等待状态
     */

    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    /**
     * 加锁，并且不释放
     */
    static class  Blocked implements  Runnable{

        @Override
        public void run() {
             // synchronized 加锁
            synchronized (Blocked.class){
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }

    static class Sync implements  Runnable{

        @Override
        public void run() {
            lock.lock();
            try {

                SleepUtils.second(100);
            }finally {
                lock.unlock();  // 释放锁
            }
        }
    }



}
