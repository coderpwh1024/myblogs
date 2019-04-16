package com.pwh.mycode.chap5;

import com.pwh.mycode.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.pwh.mycode.chap4.Dish.menu;
import static java.util.stream.Collectors.toList;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/15 17:45
 * 4
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println("-------------------------------------------");

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        System.out.println("-------------------------------------------");
        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        System.out.println("-------------------------------------------");
        Optional<Integer> optional = numbers.stream().reduce(Integer::min);
        optional.ifPresent(System.out::print);

        System.out.println();
        System.out.println("-------------------------------------------");
        int calories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);


    }
}
