package com.coderpwh.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 彭文浩 on 2017/12/25.
 */
public class Streams2 {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println(stringCollection);

    }

}
