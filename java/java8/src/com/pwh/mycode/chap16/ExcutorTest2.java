package com.pwh.mycode.chap16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author coderpwh
 * @create 2020-03-26 14:35
 * @desc ${DESCRIPTION}
 **/
public class ExcutorTest2 {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"is running");

                    try {
                        Thread.sleep(30000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
