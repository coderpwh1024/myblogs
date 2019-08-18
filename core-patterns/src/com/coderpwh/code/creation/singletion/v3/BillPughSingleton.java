package com.coderpwh.code.creation.singletion.v3;

/**
 * 比尔.普夫单例 也叫内部类方式
 *
 * @author coderpwh
 * @create 2019-08-18 16:48
 * @desc ${DESCRIPTION}
 **/
public class BillPughSingleton {


    private BillPughSingleton() {

    }

    private static class LazyHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public BillPughSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }


}
