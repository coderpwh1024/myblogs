package com.pwh.mycode.chap12;

/**
 * @author coderpwh
 * @create 2020-03-09 12:56
 * @desc ${DESCRIPTION}
 **/
public class StringDemo {

    public static void main(String[] args) {

        String s1 = new String("aaa");

        String s2 = new String("aaa");

        System.out.println(s1 == s2);

        String s3 = s1.intern();

        String s4 = s1.intern();

        System.out.println(s3 == s4);

        String s5 = "bbb";

        String s6 = "bbb";

        System.out.println(s5 == s6);

        System.out.println(s5.equals(s6));


    }
}
