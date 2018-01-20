package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/20.
 */
public class Synchronized2 {


    private static final int NUM_INCREMENTS = 1000;

    private static int count = 0;

    public static void main(String[] args) {
        testSyncIncrement();
    }


    private static void testSyncIncrement() {
        count = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executorService.submit(Synchronized2::incrementSyn));

        ConcurrentUtils.stop(executorService);

        System.out.println(count);

    }

    private static void incrementSyn() {
        synchronized (Synchronized2.class) {
            count += 1;
        }
    }


}
