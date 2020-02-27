package com.pwh.mycode.chap2;

/**
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/3/26 15:53
 * 4
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {


    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
