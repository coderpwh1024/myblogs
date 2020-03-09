package com.pwh.mycode.chap11;

import java.io.ByteArrayInputStream;

/**
 * @author coderpwh
 * @create 2020-02-27 13:50
 * @desc ${DESCRIPTION}
 **/
public class ByteArrayInputStreamDemo {


    public static void main(String[] args) {

        String tmp = "abcdefghijklmnopqrstuvwxyz";

        byte[] b = tmp.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);

        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);


    }
}
