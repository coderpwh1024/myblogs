package com.coderpwh.code.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *  可缓存的线程池
 * @author coderpwh
 * @create 2019-08-21 0:04
 * @desc ${DESCRIPTION}
 **/
public class NewCachedThreadPool {
    public static void main(String[] args) {


        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + "::" + index);
                }
            });

        }


    }
}
