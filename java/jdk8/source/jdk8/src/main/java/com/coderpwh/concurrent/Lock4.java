package com.coderpwh.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by coderpwh on 2018/1/16
 */
public class Lock4 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Map<String, String> map = new HashMap<String, String>();

        /***
         *  java8 特有的
         */
        StampedLock lock = new StampedLock();

        executorService.submit(() -> {

            long temp = lock.writeLock();

            try {
                ConcurrentUtils.sleep(1);
                map.put("foo", "bar");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(temp);
            }
        });


        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                ConcurrentUtils.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executorService.submit(readTask);
        executorService.submit(readTask);
        ConcurrentUtils.stop(executorService);


    }
}
