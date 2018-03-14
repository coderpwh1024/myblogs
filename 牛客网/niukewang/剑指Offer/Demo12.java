package com.coderpwh.niukewang;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author coderpwh
 * @Date: 2018/3/8.
 * @Description:
 */

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Demo12 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<Integer>(2);

         int i=0;
         int j=array.length-1;
         while (i<j){
             if(sum==array[i]+array[j]){
                 list.add(array[i]);
                 list.add(array[j]);
                 return  list;
             }else if(array[i]+array[j]>sum){
                 j--;
             }else{
                 i++;
             }
         }
         return  list;

    }


    @Test
    public void test() {

        int[] array = {1, 2, 4, 7, 11, 16};
        ArrayList<Integer> list = FindNumbersWithSum(array, 17);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
