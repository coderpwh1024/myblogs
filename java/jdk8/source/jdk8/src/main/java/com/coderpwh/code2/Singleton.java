package com.coderpwh.code2;

/**
 * Created by 彭文浩 on 2017/12/24.
 *
 * 线程安全的单例设计模式
 */
public class Singleton {



    private static class SingletonHanler{
        private static  Singleton singleton = new Singleton();
    }


    private  Singleton(){

    }

    public static   Singleton getSingleton(){
        return SingletonHanler.singleton;
    }


    public static void main(String[] args) {
        System.out.println(TestSingleton.getTestSingleton().hashCode());
        new Thread(()-> System.out.println(TestSingleton.getTestSingleton().hashCode()),"t1").start();
        new Thread(()-> System.out.println(TestSingleton.getTestSingleton().hashCode()),"t2").start();
        new Thread(()-> System.out.println(TestSingleton.getTestSingleton().hashCode()),"t3").start();

    }

}
