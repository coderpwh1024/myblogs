package com.pwh.mycode.chap12;

/**
 * @author coderpwh
 * @create 2020-03-12 12:15
 * @desc ${DESCRIPTION}
 **/
public class Test {

    public Object instance = null;

    public static void main(String[] args) {

        Test a = new Test();
        Test b = new Test();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;
        

    }
}
