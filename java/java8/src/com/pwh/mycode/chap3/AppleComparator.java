package com.pwh.mycode.chap3;

import java.util.Comparator;

/**
 * 比较2个对象
 *
 * @author coderpwh
 * @create 2019-04-07 16:08
 * @desc ${DESCRIPTION}
 **/
public class AppleComparator implements Comparator<Apple> {


    @Override
    public int compare(Apple o1, Apple o2) {

        return o1.getWeight().compareTo(o2.getWeight());

    }
}
