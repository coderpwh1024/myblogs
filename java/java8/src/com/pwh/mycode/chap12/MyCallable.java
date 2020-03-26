package com.pwh.mycode.chap12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author coderpwh
 * @create 2020-03-10 15:52
 * @desc ${DESCRIPTION}
 **/
public class MyCallable implements Callable<Integer> {

    public MyCallable(String s) {
    }

    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable("");

        FutureTask<Integer> ft = new FutureTask<>(mc);

        Thread thread = new Thread();
        thread.start();
        System.out.println("多线程-------Callable----");
        System.out.println(ft.get());
    }


}
