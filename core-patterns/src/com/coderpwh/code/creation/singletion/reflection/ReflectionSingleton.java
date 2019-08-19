package com.coderpwh.code.creation.singletion.reflection;

/**
 * @author coderpwh
 * @create 2019-08-19 22:30
 * @desc ${DESCRIPTION}
 **/
public class ReflectionSingleton {

    private static ReflectionSingleton INSTANCE;

    private ReflectionSingleton() {
        //throw new InstantiationError("不能通过反射创建单例");
    }

    public static synchronized ReflectionSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ReflectionSingleton();
        }
        return INSTANCE;
    }

}
