package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/19
 */
public class LongAccumulator1 {

    public static void main(String[] args) {

        testAccumulate();
    }

    private static void testAccumulate() {
        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10)
                .forEach(i -> executorService.submit(() -> accumulator.accumulate(i)));
        ConcurrentUtils.stop(executorService);
        System.out.format("Add: %d\n", accumulator.getThenReset());

    }
}
