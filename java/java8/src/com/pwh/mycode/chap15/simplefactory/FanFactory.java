package com.pwh.mycode.chap15.simplefactory;

/**
 * 工厂模式
 *
 * @author coderpwh
 * @create 2020-03-25 11:05
 * @desc ${DESCRIPTION}
 **/
public class FanFactory implements IFanFactory {

    @Override
    public IFan createFan(FanType type) {
        switch (type) {
            case TableFan:
                return new TableFan();

            case CeilingFan:
                return new CeilingFan();

            case ExhaustFan:
                return new ExhaustFan();

            default:
                return new TableFan();
        }
    }
}
