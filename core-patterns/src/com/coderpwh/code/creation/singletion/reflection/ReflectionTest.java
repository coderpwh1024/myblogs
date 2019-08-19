package com.coderpwh.code.creation.singletion.reflection;

import java.lang.reflect.Constructor;

/**
 * @author coderpwh
 * @create 2019-08-19 22:34
 * @desc ${DESCRIPTION}
 **/
public class ReflectionTest {
    public static void main(String[] args) {
        ReflectionSingleton instanceOne = ReflectionSingleton.getInstance();
        ReflectionSingleton instanceTwo = null;
        try {
            Constructor constructor = ReflectionSingleton.class.getDeclaredConstructor();
            // 下面的代码会破坏单例
            constructor.setAccessible(true);
            // 创建第二个实例
            instanceTwo = (ReflectionSingleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
