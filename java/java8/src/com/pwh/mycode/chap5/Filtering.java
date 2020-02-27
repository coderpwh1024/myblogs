package com.pwh.mycode.chap5;

import com.pwh.mycode.chap4.*;

import java.util.Arrays;
import java.util.List;

import static com.pwh.mycode.chap4.Dish.menu;

import static java.util.stream.Collectors.toList;

/**
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/4/11 10:46
 * 4
 */
public class Filtering {

    public static void main(String[] args) {

        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        vegetarianMenu.stream().forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);


        List<Dish> dishesLimit3 = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
        dishesLimit3.stream().forEach(System.out::println);

        List<Dish> dishesSkip2 = menu.stream().filter(d -> d.getCalories() > 300).skip(3).collect(toList());
        dishesSkip2.stream().forEach(System.out::println);


    }
}
