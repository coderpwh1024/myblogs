package com.coderpwh.lambda;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Created by coderpwh on 2017/12/19.
 */
public class Lambda5 {
    public static void main(String[] args) {

        BiConsumer<String,Integer>printKeyAndValue = (Key,value)-> System.out.println(Key+"-"+value);
        printKeyAndValue.accept("One",1);
        printKeyAndValue.accept("Two",2);

        System.out.println("##########################");
        HashMap<String,Integer> dummyValues = new HashMap<>();
        dummyValues.put("one",1);
        dummyValues.put("Two",2);
        dummyValues.put("Three",3);

        dummyValues.forEach((key,value)-> System.out.println(key+"-"+value));
    }
}
