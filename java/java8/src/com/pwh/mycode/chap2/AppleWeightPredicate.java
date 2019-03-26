package com.pwh.mycode.chap2;

/**
 *  重量比较
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/3/26 15:51
 * 4
 */
public class AppleWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }

}
