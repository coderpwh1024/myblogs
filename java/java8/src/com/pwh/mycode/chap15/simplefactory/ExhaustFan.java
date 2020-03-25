package com.pwh.mycode.chap15.simplefactory;

/**
 * @author coderpwh
 * @create 2020-03-25 11:09
 * @desc ${DESCRIPTION}
 **/
public class ExhaustFan implements IFan {
    @Override
    public void swithOn() {
        System.out.println("The ExhaustFan is swithed on ...");
    }

    @Override
    public void witchOff() {
        System.out.println("The ExhaustFan is swithed off ...");
    }
}
