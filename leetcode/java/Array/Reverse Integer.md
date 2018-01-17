Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 # mycode: #

```
package com.coderpwh.Leetcode;

import org.testng.annotations.Test;

/**
 * Created by coderpwh on 2018/1/15.
 */
public class ReverseInteger {

    public int reverse(int x) {

        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            x = x / 10; //不断取前几位
            if (temp / 10 != res) {
                res = 0;
                break;
            }
            res = temp;
        }
        return res;


    }

    @Test
    public void test() {

        reverse(123);
        System.out.println(reverse(1534236469));
    }


}


```