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
public class Demo16 {

    //  abc
    public int StrToInt(String str) {

           if(str ==null){
               return (int) Long.MIN_VALUE;
           }
           if(str.length()==0){
               return  0;
           }

        /***
         * 判断字符是否合法
         */
        for(int i=0;i<str.length();i++){
               if(!judge(str.charAt(i))){
                   return (int) Long.MIN_VALUE;
               }
           }
         char chars[] = str.toCharArray();
         long result = 0;

         if(chars[0]=='-'||chars[0]=='+'){
             result = trans(str.substring(1));
         }else{
             result=trans(str);
         }

        return (int) result;
    }




    private long trans(String str) {
        if (str.length() == 0) {
            return 0;
        }
        long result = 0;
        for(int i=0;i<str.length();i++){
            result = result*10+(str.charAt(i)-'0');
            if(result>Long.MAX_VALUE){
                result = Long.MIN_VALUE;
                break;
            }
        }
        return result;
    }


    private boolean judge(char c) {
        if (c == '+' || c == '-') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }


    @Test
    public void test() {
        char a = 'A';
        int b = a - 0;
        System.out.println(b);
        System.out.println( StrToInt("abc"));
        System.out.println(StrToInt("123456"));
        System.out.println(StrToInt("-6"));
        System.out.println(StrToInt("+123"));
        System.out.println("+abc");
        System.out.println("a*b");


    }


}
