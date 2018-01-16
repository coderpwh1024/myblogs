package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by coderpwh on 2018/1/16.
 */
public class Lock2 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ReentrantLock lock = new ReentrantLock();

        executorService.submit(() -> {
            lock.lock();
            try {
                ConcurrentUtils.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executorService.submit(() -> {
            System.out.println("Locked:" + lock.isLocked());
            System.out.println("Held by me：" + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired:" + locked);

        });

        ConcurrentUtils.stop(executorService);

    }
}
