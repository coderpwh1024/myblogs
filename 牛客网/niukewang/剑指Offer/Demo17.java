package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/14.
 * @Description:
 */

import org.testng.annotations.Test;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Demo17 {

    public int StrToInt(String str) {

        if ("".equals(str)) {
            return 0;
        }

        int result = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return 0;
                }
                result = result * 10 + (str.charAt(i) - '0');
            }
            if (str.charAt(0) == '-') {
                return 0 - result;
            }

        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return 0;
                }
                result = result * 10 + (str.charAt(i) - '0');
            }

        }

        return result;
    }


     @Test
     public void test(){

         System.out.println(StrToInt("abc"));
         System.out.println(StrToInt("+12545"));
         System.out.println(StrToInt("-45"));
         System.out.println(StrToInt("-ab"));
         System.out.println(StrToInt("a+b"));
     }


}
