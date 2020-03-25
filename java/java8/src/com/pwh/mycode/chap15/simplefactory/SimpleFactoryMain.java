package com.pwh.mycode.chap15.simplefactory;

/**
 *  工厂模式
 * @author coderpwh
 * @create 2020-03-25 14:07
 * @desc ${DESCRIPTION}
 **/
public class SimpleFactoryMain {
    public static void main(String[] args) {
        IFanFactory simpleFactory = new FanFactory();

        IFan fan = simpleFactory.createFan(FanType.TableFan);

        fan.swithOn();
        fan.witchOff();
    }

}
