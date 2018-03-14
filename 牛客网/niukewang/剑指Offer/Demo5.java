package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/7.
 * @Description:
 */

import org.testng.annotations.Test;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Demo5 {
    public int Sum_Solution(int n) {

         int sum=n;
         boolean bool = ((sum!=0)&&(sum+=Sum_Solution(n-1))!=0);
         return sum;

    }

    @Test
    public void test(){
        Sum_Solution(100);
        System.out.println( Sum_Solution(100));

    }
}
