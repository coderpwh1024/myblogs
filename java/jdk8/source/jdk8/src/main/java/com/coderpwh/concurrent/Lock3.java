package com.coderpwh.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by coderpwh on 2018/1/16.
 */
public class Lock3 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Map<String, String> map = new HashMap<String, String>();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        executorService.submit(() -> {
            lock.writeLock().lock();
            try {
                ConcurrentUtils.sleep(1);
                map.put("foo", "bar");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
                ConcurrentUtils.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        };
        executorService.submit(readTask);
        executorService.submit(readTask);

        ConcurrentUtils.stop(executorService);


    }
}
