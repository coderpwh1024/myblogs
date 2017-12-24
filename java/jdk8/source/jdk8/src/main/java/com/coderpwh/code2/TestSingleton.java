package com.coderpwh.code2;

import java.util.concurrent.TimeUnit;

/**
 * Created by 彭文浩 on 2017/12/24.
 *
 * 线程不安全的单例设计模式
 */
public class TestSingleton {

    private static TestSingleton  testSingleton;


    private  TestSingleton(){

    }

    public static  TestSingleton getTestSingleton(){

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(testSingleton==null){
            testSingleton = new TestSingleton();
        }
        return  testSingleton;

    }

    public static void main(String[] args) {
//        TestSingleton.getTestSingleton().hashCode();
        System.out.println(TestSingleton.getTestSingleton().hashCode());
        new Thread(()-> System.out.println(TestSingleton.getTestSingleton().hashCode()),"t1").start();
        new Thread(()-> System.out.println(TestSingleton.getTestSingleton().hashCode()),"t2").start();
        new Thread(()-> System.out.println(TestSingleton.getTestSingleton().hashCode()),"t3").start();


    }

}
