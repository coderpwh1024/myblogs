package com.coderpwh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by coderpwh on 2018/1/9.
 */
public class ConcurrentUtils {

    public static void stop(ExecutorService executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }finally {
            if(!executor.isTerminated()){
                System.err.println("killing non-finished tasks");
            }
            executor.shutdown();
        }

    }

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw  new IllegalStateException(e);
        }
    }



}
