package com.pwh.mycode.chap6;

import static com.pwh.mycode.chap6.Dish.menu;
import static java.util.stream.Collectors.*;

/**
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/4/19 14:31
 * 4
 */
public class Reducing {
    public static void main(String[] args) {

        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
    }


    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }


}
