package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by coderpwh on 2018/1/17.
 */
public class Lock5 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        StampedLock lock = new StampedLock();

        executorService.submit(() -> {
            long stamp = lock.tryOptimisticRead();

            try {
                System.out.println("Optimistic Lock Valid:" + lock.validate(stamp));
                ConcurrentUtils.sleep(1);
                System.out.println("Optimistic Lock Valid:" + lock.validate(stamp));
                ConcurrentUtils.sleep(2);
                System.out.println("Optimistic Lock Valid:" + lock.validate(stamp));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
            }
        });

        executorService.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                ConcurrentUtils.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });
        ConcurrentUtils.stop(executorService);


    }
}
