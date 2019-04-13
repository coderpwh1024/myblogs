package com.pwh.mycode.chap5;

import com.pwh.mycode.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.pwh.mycode.chap4.Dish.menu;
import static java.util.stream.Collectors.toList;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/11 11:22
 * 4
 */
public class Mapping {
    public static void main(String[] args) {

        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
        dishNames.stream().forEach(System.out::println);

        System.out.println("--------------------------------");
        List<String> words = Arrays.asList("Hello", "World");

        List<Integer> wordsList = words.stream().map(String::length).collect(toList());
        wordsList.stream().forEach(System.out::println);

        System.out.println("--------------------------------");
        words.stream().flatMap((String line) -> Arrays.stream(line.split(""))).distinct().forEach(System.out::println);


        System.out.println("--------------------------------");
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList()).forEach(System.out::println);

        System.out.println("--------------------------------");

        // 求下列数组的平方
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(r -> r * r).collect(toList());
        squares.stream().forEach(System.out::println);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);

        List<int[]> pairs = numbers1.stream().flatMap((Integer i) -> numbers2.stream().map((Integer j) -> new int[]{i, j}))
                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                .collect(toList());

        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

    }
}
