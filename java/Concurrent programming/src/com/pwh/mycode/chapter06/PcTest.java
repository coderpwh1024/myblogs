package com.pwh.mycode.chapter06;

import java.util.concurrent.*;

/**
 * Created by 彭文浩 on 2018/7/14.
 */
public class PcTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

        Consumer consumer = new Consumer(queue);

        Producer producer = new Producer( queue);

        for (int i=0;i<5;i++){

            new Thread(producer,"producer"+(i+1)).start();

            new Thread(consumer,"producer"+(i+1)).start();

        }


    }
}
