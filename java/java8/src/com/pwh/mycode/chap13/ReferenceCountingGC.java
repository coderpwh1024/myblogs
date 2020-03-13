package com.pwh.mycode.chap13;

/**
 * @author coderpwh
 * @create 2020-03-13 13:17
 * @desc ${DESCRIPTION}
 **/
public class ReferenceCountingGC {

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public Object instance = null;

    public static void main(String[] args) {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();


    }
}
