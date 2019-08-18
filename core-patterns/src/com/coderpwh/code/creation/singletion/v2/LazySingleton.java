package com.coderpwh.code.creation.singletion.v2;

/**
 * @author coderpwh
 * @create 2019-08-18 14:57
 * @desc ${DESCRIPTION}
 **/

/**
 * 懒汉式
 */
public class LazySingleton {

    private static LazySingleton INSTANCE;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

}
