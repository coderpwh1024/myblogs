package com.pwh.mycode.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author coderpwh
 * @create 2019-04-07 16:50
 * @desc ${DESCRIPTION}
 **/
public class StreamBasic {
    public static void main(String[] args) {
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }


    // java7 code
    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        List<String> lowCaloricDishesName = new ArrayList<>();

        // 排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }

        return lowCaloricDishesName;
    }


    //  java8 code

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {

        return dishes.stream().
                filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());


    }


}
