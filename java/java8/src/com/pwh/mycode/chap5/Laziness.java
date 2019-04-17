package com.pwh.mycode.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/17 16:04
 * 4
 */
public class Laziness {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);


        List<Integer> list = numbers.stream().filter(r -> {
            System.out.print("filtering r:" + r);
            return r % 2 == 0;
        }).map(n -> {
            System.out.println("map:" + n);
            return n * n;
        }).limit(2).collect(Collectors.toList());

        System.out.println("----------------------------");
        list.stream().forEach(r -> {
            System.out.println(r);
        });


    }
}
