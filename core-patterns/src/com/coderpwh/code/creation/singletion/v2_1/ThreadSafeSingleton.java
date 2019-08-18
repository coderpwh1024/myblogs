package com.coderpwh.code.creation.singletion.v2_1;

/**
 * 线程安全的单例设计模式
 *
 * @author coderpwh
 * @create 2019-08-18 15:04
 * @desc ${DESCRIPTION}
 **/
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton INSTANCE;


    private ThreadSafeSingleton() {

    }


    public static synchronized ThreadSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeSingleton();
        }
        return INSTANCE;

    }

}
