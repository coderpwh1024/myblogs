package com.coderpwh.stream;

import java.util.Arrays;

/**
 * Created by coderpwh on 2017/12/27.
 */
public class Streams9 {
    public static void main(String[] args) {


         // 先过滤不是c 开头，后转大写
        Arrays.asList("a1","a2","b1","c2","c1")
                .stream()
                .filter(s->s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
