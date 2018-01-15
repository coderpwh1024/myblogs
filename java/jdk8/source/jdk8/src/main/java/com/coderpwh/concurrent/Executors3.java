package com.coderpwh.concurrent;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by coderpwh on 2018/1/12.
 */
public class Executors3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();

    }


    private static void test1() throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Runnable task = () -> System.out.println("Scheduling:" + System.nanoTime());
        int delay = 3;
        ScheduledFuture<?> future = scheduledExecutorService.schedule(task, delay, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Rmaining Delay: %sms\n", remainingDelay);

    }

    private static void test2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling:" + System.nanoTime());
        int initiaDelay = 0;
        int period = 1;
        scheduledExecutorService.scheduleAtFixedRate(task, initiaDelay, period, TimeUnit.SECONDS);

    }

    private static void test3() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling:" + System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println("task interrupdated");
            }
        };
        scheduledExecutorService.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

    }

    private static void test4() throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3",
                () -> "task4");

        executorService.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(System.out::println);
        executorService.shutdown();

    }


    private static void test5() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Lists.newArrayList(callable("task1", 2), callable("task2", 1), callable("task3", 3));

        String result = executorService.invokeAny(callables);

        System.out.println(result);

        executorService.shutdown();


    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }


}
