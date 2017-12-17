package com.coderpwh.code2;

/**
 * Created by 彭文浩 on 2017/12/17.
 */
public class Java8Tester {

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {

        Java8Tester tester = new Java8Tester();

        MathOperation addition = (int a,int b) -> a+b;

        MathOperation subtraction = (a,b)->a-b;

        MathOperation multiplication = (int a,int b)->{return a*b;};

        MathOperation division = (int a,int b)->a/b;

        System.out.println("10+5="+tester.operate(10,5,addition));

        System.out.println("10-5="+tester.operate(10,5,subtraction));

        System.out.println("10*5="+tester.operate(10,5,multiplication));

        System.out.println("10*5="+tester.operate(10,5,division));

        GreetingService greetService1 = message -> System.out.println("hello"+message);

        GreetingService greetingService2 = (message) -> System.out.println("hello"+message);

        greetService1.sayMessage("Masheh");
        greetingService2.sayMessage("Surech");






    }
}
