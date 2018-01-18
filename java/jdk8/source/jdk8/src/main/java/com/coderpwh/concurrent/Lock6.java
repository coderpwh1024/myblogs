package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by coderpwh on 2018/1/18.
 */
public class Lock6 {

    private static int count = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        StampedLock lock = new StampedLock();

        executorService.submit(() -> {
            long stamp = lock.readLock();

            try {
                if (count == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if (stamp == 0L) {
                        System.out.println("Cloud not convert to write lock");
                        stamp = lock.writeLock();
                    }
                    count = 23;
                }
                System.out.println(count);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
            }

        });
        ConcurrentUtils.stop(executorService);

    }
}
