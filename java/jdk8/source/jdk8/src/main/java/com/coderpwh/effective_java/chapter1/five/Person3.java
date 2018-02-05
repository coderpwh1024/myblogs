package com.coderpwh.effective_java.chapter1.five;

/**
 * @author coderpwh
 * @Date: 2018/1/31.
 * @Description:
 */
public class Person3 {

    public static void main(String[] args) {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
