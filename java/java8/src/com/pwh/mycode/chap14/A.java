package com.pwh.mycode.chap14;

/**
 * @author coderpwh
 * @create 2020-03-23 10:51
 * @desc ${DESCRIPTION}
 **/
public class A {

    private static  int  numA;

    private int  numA2;

    static {

        System.out.println("A的静态字段:"+numA);
        System.out.println("A的静态的代码块");
    }

    {
        System.out.println("A的成员变量:"+numA2);
        System.out.println("A的非静态代码块");
    }

    public A(){
        System.out.println("A的构造器");
    }

}
