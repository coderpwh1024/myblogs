package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/2.
 * @Description:
 */

import org.testng.annotations.Test;

/***
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Demo3 {

    public int minNumberInRotateArray(int [] array) {

        if(array.length==0){
            return  0;
        }else{
            for(int i=0;i<array.length;i++){
                int temp;
                 for(int j=i+1;j<array.length-1;j++){
                     if(array[i]>array[j]){
                         temp = array[i];
                         array[i] = array[j];
                         array[j]=temp;
                     }
                 }

            }
            return array[0];
        }

    }


    @Test
    public  void test(){

          int arr []={3,4,5,1,2};

    }

}
