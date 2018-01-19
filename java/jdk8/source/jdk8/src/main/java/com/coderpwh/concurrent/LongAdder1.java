package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/19.
 */
public class LongAdder1 {


    private static final int NUM_INCREMENTS = 10000;

    private static LongAdder adder = new LongAdder();

    public static void main(String[] args) {
        testIncrement();
        testAdd();

    }

    private static void testIncrement() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executorService.submit(adder::increment));

        ConcurrentUtils.stop(executorService);

        System.out.format("Increment:Expected=%d;Is=%d\n", NUM_INCREMENTS, adder.sumThenReset());

    }

    private static void testAdd() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executorService.submit(() -> adder.add(2)));
        ConcurrentUtils.stop(executorService);
        System.out.format("Add：%d\n", adder.sumThenReset());
    }

}
