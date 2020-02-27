package com.pwh.mycode.chap10;

/**
 * @author coderpwh
 * @create 2020-02-27 12:34
 * @desc ${DESCRIPTION}
 **/
public class SubStringCons {
    public static void main(String[] args) {
        byte assci[] = {65, 66, 67, 68, 69, 70};

        String s1 = new String(assci);
        System.out.println(s1);

        String s2 = new String(assci, 2, 3);
        System.out.println(s2);
    }
}
