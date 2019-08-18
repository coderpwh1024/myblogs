package com.coderpwh.code.creation.singleton.v1;

/**
 * @author coderpwh
 * @create 2019-08-18 14:44
 * @desc ${DESCRIPTION}
 **/
public class EagerSingleton {

    private final static EagerSingleton INSTANCE = new EagerSingleton();

    // 私有构造函数
    private EagerSingleton() {

    }


    public static EagerSingleton getINSTANCE() {
        return INSTANCE;
    }

}
