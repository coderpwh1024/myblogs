package com.pwh.mycode.chap2;

/**
 * 颜色比较
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/3/26 15:52
 * 4
 */
public class AppleColorPredicate implements ApplePredicate {


    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
