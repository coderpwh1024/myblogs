package com.coderpwh.concurrent;

import java.util.concurrent.*;

/**
 * Created by coderpwh on 2018/1/11.
 */
public class Executors2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
    }

    private static void test1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        System.out.println("future done:" + future.isDone());
        Integer result = future.get();

        System.out.println("future done:" + future.isDone());
        System.out.println("result:" + result);
        executorService.shutdownNow();


    }


}
