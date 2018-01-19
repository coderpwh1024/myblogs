package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/19.
 */
public class Semaphore1 {

    private static final int NUM_INCREMENTS = 1000;

    private static Semaphore semaphore = new Semaphore(1);

    private static int count = 0;

    public static void main(String[] args) {
        testIncrement();
    }

    private static void testIncrement() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executorService.submit(Semaphore1::increment));

        ConcurrentUtils.stop(executorService);
        System.out.println("InCrement:" + count);
    }

    private static void increment() {

        boolean permit = false;

        try {
            permit = semaphore.tryAcquire(5, TimeUnit.SECONDS);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (permit) {
                semaphore.release();
            }
        }
    }

}
