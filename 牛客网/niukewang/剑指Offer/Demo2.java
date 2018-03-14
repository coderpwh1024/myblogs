package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/2.
 * @Description:
 */

/**
 *请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Demo2 {
    public String replaceSpace(StringBuffer str) {

          for(int i=0;i<str.length();i++){

               char a = str.charAt(i);
               if(a==' '){
                   str.replace(i,i+1,"%20");
               }
          }
          return  str.toString();

    }


}
