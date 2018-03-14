package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/7.
 * @Description:
 */

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class Demo7 {

    public int Fibonacci(int n) {

         if(n<=0){
             return  0;
         }else if(n==1){
             return 1;
         }else{
             return Fibonacci(n-1)+Fibonacci(n-2);
         }
    }

}
