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
 * 3 * @Date: 2019/4/12 11:16
 * 4
 */
public class Finding {
    public static void main(String[] args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        System.out.println("---------------------------");

        Optional<Dish> optionalDish = findVegetarianDish();
        optionalDish.ifPresent(d -> System.out.println(d.getName()));

    }


    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().anyMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }


}
