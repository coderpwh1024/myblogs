package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/20.
 */
public class Synchronized1 {

    private static final int NUM_INCREMENTS = 1000;

    private static int count = 0;

    public static void main(String[] args) {

        testNonSyncIncrement();
        testSyncIncrement();
    }

    private static void testNonSyncIncrement() {

        count = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executorService.submit(Synchronized1::increment));

        ConcurrentUtils.stop(executorService);

        System.out.println("NonSync:" + count);

    }

    private static void testSyncIncrement() {
        count = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executorService.submit(Synchronized1::incrementSync));
        ConcurrentUtils.stop(executorService);
        System.out.println("Sync:" + count);
    }


    private static void increment() {
        count += 1;
    }

    private static synchronized void incrementSync() {
        count += 1;
    }


}
