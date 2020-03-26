package com.pwh.mycode.chap16;

import com.pwh.mycode.chap12.MyCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author coderpwh
 * @create 2020-03-26 14:02
 * @desc ${DESCRIPTION}
 **/
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 10;

        ExecutorService  pool = Executors.newFixedThreadPool(taskSize);

        List<Future> list = new ArrayList<Future>();
         for(int i=0;i<taskSize;i++){
             Callable c = new MyCallable(i+" ");
             Future f = pool.submit(c);
             list.add(f);
         }

         pool.shutdown();

         for(Future f:list){
             System.out.println("res:"+f.get().toString());
         }


    }
}
