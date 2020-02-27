package com.pwh.mycode.chap6;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.pwh.mycode.chap6.Dish.dishTags;
import static com.pwh.mycode.chap6.Dish.menu;
import static java.util.stream.Collectors.*;

/**
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/4/19 14:52
 * 4
 */
public class Grouping {

    public static void main(String[] args) {

        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Dish names grouped by type: " + groupDishNamesByType());
    }


    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    private static  Map<Dish.Type,List<Integer>> groupDishNamesByType(){
        return  menu.stream().collect(groupingBy(Dish::getType,mapping(Dish::getCalories,toList())));
    }






}
