package com.coderpwh.stream;

import com.beust.jcommander.internal.Lists;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by coderpwh on 2018/1/3.
 */
public class Streams12 {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a1","a2","b1","b2","c2","c1");
//         test1();
         test2(list);


    }
    private static  void test1(){
        // 线程池
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.print(commonPool.getParallelism());
    }

    private  static void test2(List<String> strings){

        strings.parallelStream().filter(s->{
            System.out.format("filter:%s [%s]\n",s,Thread.currentThread().getName());
            return true;
        }).map(s->{
            System.out.format("map: %s[%s]\n",s,Thread.currentThread().getName());
            return s.toUpperCase();
        }).forEach(s->System.out.format("forEach:%s[%s]\n",s,Thread.currentThread().getName()));

    }


}
