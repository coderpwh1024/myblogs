package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2018/1/9
 */
public class Atomic1 {

    private static final int NUM_INCREMENTS = 1000;

    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public static void main(String[] args) {
           testIncrement();

    }

    private static void testIncrement(){
        atomicInt.set(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,NUM_INCREMENTS)
                .forEach(i->executorService.submit(atomicInt::incrementAndGet));

         ConcurrentUtils.stop(executorService);

         System.out.format("Increment: Expected=%d; Is=%d\n",NUM_INCREMENTS,atomicInt.get());

    }
}
