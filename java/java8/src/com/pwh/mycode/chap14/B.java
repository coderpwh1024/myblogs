package com.pwh.mycode.chap14;

/**
 * @author coderpwh
 * @create 2020-03-23 10:56
 * @desc ${DESCRIPTION}
 **/
public class B extends  A {

    private  static  int numB;

    private  int numB2;

    static {
        System.out.println("B的静态字段:"+numB);
        System.out.println("B的静态代码块");
    }

    {
        System.out.println("B的成员变量:"+numB2);
        System.out.println("B的非静态代码块");
    }

    public B(){
        System.out.println("B的构造器");
    }


    



}
