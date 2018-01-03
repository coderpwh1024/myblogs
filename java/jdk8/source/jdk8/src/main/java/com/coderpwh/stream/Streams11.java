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
//        test1(list);
//        test2(list);
//        test3(list);
//        test4(list);
//        test5(list);
           test6(list);


    }

    public static void test1(List<Person> persons){
        persons.stream().reduce((p1,p2)->p1.age>p2.age?p1:p2).ifPresent(System.out::println);

    }

    public static void test2(List<Person> persons){

         Person result = persons.stream().reduce(new Person("",0),(p1,p2)->{
             p1.age+=p2.age;
             p1.name+=p2.name;
             return p1;
         });

         System.out.format("name=%s;age=%s",result.name,result.age);
    }

    public static void test3(List<Person> persons){

        Integer ageSum = persons.stream().reduce(0,(sum,p)->sum+=p.age,(sum1,sum2)->sum1+sum2);

        System.out.println(ageSum);

    }


    public static void test4(List<Person> persons){
         Integer ageSum = persons.stream().reduce(0,(sum,p)->{
             System.out.format("accumulator:sum=%s;person=%s\n",sum,p);
             return  sum +=p.age;
         },
                 (sum1,sum2)->{
             System.out.format("combiner: sum1=%s;sum2=%s\n",sum1,sum2);
               return sum1+sum2;
                 });


    }


    public  static  void test5(List<Person>persons){

        Integer ageSum = persons.parallelStream().reduce(0,
                (sum,p)->{
               System.out.format("accumulator:sum=%s;person=%s\n",sum,p);
                return  sum+=p.age;
                },
                (sum1,sum2)->{
                System.out.format("combiner:sum1=%s;sum2=%s\n",sum1,sum2);
                 return sum1+sum2;
                });
    }

    private static void test6(List<Person> persons){

        Integer ageSum = persons.parallelStream()
                .reduce(0,(sum,p)->{
                    System.out.format("accumulator: sum=%s;person=%s;thread=%s\n",sum,p,Thread.currentThread().getName());
                    return sum+=p.age;
                },
                        (sum1,sum2)->{
                    System.out.format("combiner:sum=%s;sum=%s;thread=%s\n",sum1,sum2,Thread.currentThread().getName());
                    return sum1+sum2;
                });
    }




}
