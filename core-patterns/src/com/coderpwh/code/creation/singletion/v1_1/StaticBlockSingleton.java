package com.coderpwh.code.creation.singletion.v1_1;

/**
 * @author coderpwh
 * @create 2019-08-18 14:49
 * @desc ${DESCRIPTION}
 **/
// 静态初始化单例模块
public class StaticBlockSingleton {

    private static final StaticBlockSingleton INSTANCE;

    // 私有构造函数
    private StaticBlockSingleton() {

    }

    static {

        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("异常结果为:" + e);
        }
    }


    public static StaticBlockSingleton getINSTANCE() {
        return INSTANCE;
    }
}
