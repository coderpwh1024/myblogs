package com.pwh.mycode.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author coderpwh
 * @create 2019-04-09 23:06
 * @desc ${DESCRIPTION}
 **/
public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
    }
}
