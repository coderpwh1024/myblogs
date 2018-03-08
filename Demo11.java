package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/8.
 * @Description:
 */

/***
 * 统计一个数字在排序数组中出现的次数。
 */
public class Demo11 {

    public int GetNumberOfK(int [] array , int k) {

         int sum=0;
         for(int i=0;i<array.length;i++){
             if(array[i]==k){
                 sum+=1;
             }
         }
         return  sum;

    }
}
