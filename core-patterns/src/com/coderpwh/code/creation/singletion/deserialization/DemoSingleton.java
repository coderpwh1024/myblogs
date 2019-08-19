package com.coderpwh.code.creation.singletion.deserialization;

import java.io.Serializable;

/**
 * @author coderpwh
 * @create 2019-08-19 22:20
 * @desc ${DESCRIPTION}
 **/
public class DemoSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;


    private static class LazyHolder {
        private static final DemoSingleton INSTANCE = new DemoSingleton();

    }

    public static DemoSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }


}
