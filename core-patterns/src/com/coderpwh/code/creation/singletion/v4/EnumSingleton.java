package com.coderpwh.code.creation.singletion.v4;

/**
 * 枚举方式
 *
 * @author coderpwh
 * @create 2019-08-18 16:53
 * @desc ${DESCRIPTION}
 **/
public enum EnumSingleton {
    INSTANCE;

    // 添加单例方法
    public void method() {
        System.out.println("Singleton method called...");
    }
}
