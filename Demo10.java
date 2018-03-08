package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/8.
 * @Description:
 */

/***
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class Demo10 {

    public double Power(double base, int exponent) {

        double sum = 1;

        if(exponent>0){
            for(int i=1;i<=exponent;i++){
                sum*=base;
            }
        }else if(exponent<0){
            for(int i=1;i<=Math.abs(exponent);i++){
                sum*=(1/base);
            }
        }else{
            sum=1;
        }

        return  sum;

    }

}
