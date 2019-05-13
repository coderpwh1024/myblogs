package com.pwh.mycode.chap8;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/5/13 17:28
 * 4
 */
public class IsNumeric implements ValidationStrategy {


    @Override
    public boolean execute(String s) {

        return s.matches("\\d");
    }

}
