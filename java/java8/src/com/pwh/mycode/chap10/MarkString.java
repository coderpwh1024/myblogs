package com.pwh.mycode.chap10;

/**
 * @author coderpwh
 * @create 2020-02-27 12:28
 * @desc ${DESCRIPTION}
 **/
public class MarkString {

    public static void main(String[] args) {
        char c[] = {'J', 'a', 'v', 'a'};

        String s1 = new String(c);

        String s2 = new String(s1);


        System.out.println(s1);

        System.out.println(s2);
    }
}
