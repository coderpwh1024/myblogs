package com.pwh.mycode.chap15.simplefactory;

/**
 * @author coderpwh
 * @create 2020-03-25 11:03
 * @desc ${DESCRIPTION}
 **/
public interface IFanFactory {

    IFan createFan(FanType type);
}
