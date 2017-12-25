package com.coderpwh.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by 彭文浩 on 2017/12/25.
 */
public class Streams1 {

    public static void main(String[] args) {
        List<String> stringCollection  = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // filtering
        stringCollection
                .stream()
                .filter((s)->s.startsWith("a"))
                .forEach(System.out::println);   // aaa2 aaa1

        System.out.println("= = = = = = = = = = = = = = = =");


         // 先排序后过滤
        stringCollection
                .stream()
                .sorted()
                .filter((s)->s.startsWith("a"))
                .forEach(System.out::println);

        System.out.println("= = = = = = = = = = = = = = = =");


         //  DDD2 DDD1 CCC BBB3 BBB2 BBB1 AAA2 AAA1
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b)->b.compareTo(a))
                .forEach(System.out::println);

        System.out.println("= = = = = = = = = = = = = = = =");

         boolean  anyStartsWithA  = stringCollection
                .stream()
                .anyMatch((s)->s.startsWith("a"));

        System.out.println(anyStartsWithA);   // true

        System.out.println("= = = = = = = = = = = = = = = =");

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((s)->s.startsWith("a"));

        System.out.println(allStartsWithA);   // false

        System.out.println("= = = = = = = = = = = = = = = =");

        boolean noneStartWithZ = stringCollection
                .stream()
                .noneMatch((s)->s.startsWith("z"));

        System.out.println(noneStartWithZ);   // true

        System.out.println("= = = = = = = = = = = = = = = =");


        long startWithB = stringCollection
                .stream()
                .filter((s)->s.startsWith("b"))
                .count();

        System.out.println(startWithB);  // 3

        System.out.println("= = = = = = = = = = = = =");

        Optional<String> reduce =  stringCollection.stream()
                 .sorted()
                 .reduce((s1,s2)->s1+"#"+s2);

        reduce.ifPresent(System.out::println);















    }
}
