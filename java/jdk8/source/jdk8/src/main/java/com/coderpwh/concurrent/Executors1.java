package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by coderpwh on 2018/1/11.
 */
public class Executors1 {
    public static void main(String[] args) {
          test1(3);
    }

    private static void test1(long seconds) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("task finished：" + name);
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });
        stop(executorService);

    }

    static void stop(ExecutorService executorService) {
        try {
            System.out.println("关闭 executorService");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
