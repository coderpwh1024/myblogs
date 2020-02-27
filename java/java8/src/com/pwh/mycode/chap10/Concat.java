package com.pwh.mycode.chap10;

/**
 * @author coderpwh
 * @create 2020-02-27 12:39
 * @desc ${DESCRIPTION}
 **/
public class Concat {
    public static void main(String[] args) {

        String  longStr="This cloud  have been "+"a very long line that would have"+"wrapped around. But string " +
                "concatenation"+"prevents this.";

        System.out.println(longStr);

        System.out.println(longStr.length());

        int age = 9;

        String str = " He is " + age + " years old.";
        System.out.println(str);


    }
}
