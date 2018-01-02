package com.coderpwh.stream;

import com.beust.jcommander.internal.Lists;

import java.util.List;

/**
 * Created by coderpwh on 2018/1/2.
 */
public class Streams11 {


    static class Person{
        String name ;
        int age;

        Person(String name,int age){
            this.name = name;
            this.age = age;

        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Person> list = Lists.newArrayList(new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));
        test1(list);



    }

    public static void test1(List<Person> persons){
        persons.stream().reduce((p1,p2)->p1.age>p2.age?p1:p2).ifPresent(System.out::println);

    }




}
