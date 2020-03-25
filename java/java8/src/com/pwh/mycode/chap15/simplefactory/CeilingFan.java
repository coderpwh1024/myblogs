package com.pwh.mycode.chap15.simplefactory;

/**
 * @author coderpwh
 * @create 2020-03-25 10:59
 * @desc ${DESCRIPTION}
 **/
public class CeilingFan implements IFan {
    @Override
    public void swithOn() {
        System.out.println("The ceilingFan is swithed on ...");
    }

    @Override
    public void witchOff() {
        System.out.println("The CeilingFan is swithed off....");
    }
}
