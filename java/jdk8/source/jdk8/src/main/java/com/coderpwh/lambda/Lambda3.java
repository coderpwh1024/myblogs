package com.coderpwh.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by coderpwh on 2017/12/19.
 */
public class Lambda3 {

    @FunctionalInterface
    interface  Fun{
       void foo();
    }

    public static void main(String[] args) throws Exception {

         //  Predicate 接口
        Predicate<String > predicate =(s)-> s.length()>0;

        predicate.test("foo");
        System.out.println(predicate.test("foo"));
        predicate.negate().test("foo");

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


         // Function 接口
        Function<String, Integer> toInteger = Integer::valueOf;

        Function<String ,String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");
        System.out.println(backToString.apply("123"));


        // Consumer 接口
        Consumer<Person> greeter =(p)-> System.out.println("Hello,"+p.firstName);
        greeter.accept(new Person("Luke","Skywaler"));


        // comparator 接口
        Comparator<Person> comparator = (p1,p2)->p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("Johne","Doe");

        Person p2 = new Person("Alice","Wonderland");


       comparator.compare(p1,p2);
       System.out.println(comparator.compare(p1,p2));

       comparator.reversed().compare(p1,p2);
       System.out.println(comparator.reversed().compare(p1,p2));


        // Runnable 接口
       Runnable runnable = ()-> System.out.println(UUID.randomUUID());
       runnable.run();

       // Callables 接口
        Callable<UUID> callable = UUID::randomUUID;
        callable.call();














    }


}
