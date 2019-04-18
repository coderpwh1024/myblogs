package com.pwh.mycode.chap5;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/17 16:20
 * 4
 */
public class BuildingStreams {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        System.out.println("-------------------------------------");

        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

        System.out.println("-------------------------------------");
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        System.out.println("-------------------------------------");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[0], t[0] + t[1]}).limit(10).forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));


        System.out.println("-------------------------------------");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[0], t[0] + t[1]}).limit(10).map(t -> t[0]).forEach(System.out::println);


        System.out.println("-------------------------------------");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        System.out.println("-------------------------------------");
        Stream.generate(() -> 1).limit(5).forEach(System.out::println);


        System.out.println("-------------------------------------");
        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);


    }
}
