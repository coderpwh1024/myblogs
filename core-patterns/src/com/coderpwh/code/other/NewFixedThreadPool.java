package com.coderpwh.code.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author coderpwh
 * @create 2019-08-21 0:13
 * @desc ${DESCRIPTION}
 **/
public class NewFixedThreadPool {

    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + ":" + index);
                }
            });


        }
    }
}
