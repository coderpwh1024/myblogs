package com.pwh.mycode.chapter06;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 彭文浩 on 2018/7/14.
 */
public class Consumer implements  Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp =  queue.take();
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
