package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/16.
 * @Description:
 */

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/***
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Demo19 {


    /**
     * map方式
     *
     * @param str
     * @return
     */

    public int FirstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }


        char arr[] = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(arr[i]) != null) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }

        return -1;
    }


    /***
     * 数组
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }
        for(int i=0;i<str.length();i++){
            char a = str.charAt(i);
            boolean flag = false;
            String s = str.substring(i+1,str.length());
            for(int j=0;j<s.length();j++){
                if(a==s.charAt(j)){
                    flag = true;
                }
            }
            if(flag==false){
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test(){

        String str = "bcdabcdbcde";
       /* str.substring(0);
        System.out.println(str.substring(0));
        System.out.println(str.substring(1,str.length()-1));


        FirstNotRepeatingChar2(str);*/

        System.out.println(FirstNotRepeatingChar(str));
        System.out.println(FirstNotRepeatingChar2(str));
    }



}
