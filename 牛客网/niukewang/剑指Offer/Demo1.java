package com.coderpwh.niukewang;

import org.testng.annotations.Test;

/**
 * @author coderpwh
 * @Date: 2018/3/1.
 * @Description:
 */
public class Demo1 {


    public boolean Find(int target, int[][] array) {
        boolean flag = false;
        boolean temp = false;


        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[0].length; j++) {

                if (array[i][j] == target) {
                    flag = true;
                    temp = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            }

        }

        return flag;
    }


    @Test
    public void test() {

        int arr[][] = {{1, 2, 3}, {24, 6, 56}, {2, 5, 6}};
        int a = 24;
        Find(24, arr);
        System.out.println(Find(24, arr));
    }
}
