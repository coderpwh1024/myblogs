package com.coderpwh.code.creation.singletion.v2_2;

/**
 * // 双重检查锁定单例
 *
 * @author coderpwh
 * @create 2019-08-18 15:08
 * @desc ${DESCRIPTION}
 **/
public class DoubleCheckLockingSingleton {

    private static volatile DoubleCheckLockingSingleton INSTANCE;

    private DoubleCheckLockingSingleton() {

    }

    public static DoubleCheckLockingSingleton getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }


}
