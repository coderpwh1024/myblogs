package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/15.
 */
public class Lock1 {

    private static final int NUM_INCREMENTS = 10000;

    private static ReentrantLock lock = new ReentrantLock();

    private static int count = 0;

    private static void increment() {
        lock.lock();
        try {
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    private static void testLock() {
        count = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, NUM_INCREMENTS).forEach(i -> executorService.submit(Lock1::increment));

        ConcurrentUtils.stop(executorService);
        System.out.println(count);
    }


    public static void main(String[] args) {

        testLock();
    }
}
