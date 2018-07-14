package com.pwh.mycode.chapter06;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 彭文浩 on 2018/7/14.
 */
public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            String temp = "A Product,生产线程:" + Thread.currentThread().getName();
            System.out.println("I have made a product" + Thread.currentThread().getName());
            queue.put(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
