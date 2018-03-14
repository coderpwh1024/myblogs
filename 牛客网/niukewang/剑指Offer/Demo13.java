package com.coderpwh.niukewang;

import org.testng.annotations.Test;

/**
 * @author coderpwh
 * @Date: 2018/3/9.
 * @Description:
 */
public class Demo13 {

    public String LeftRotateString(String str,int n) {


        StringBuilder sb = new StringBuilder();
          if(n<=str.length()){
              String b = str.substring(0,n);
              String e = str.substring(n,str.length());
              System.out.println(b);
              System.out.println(e);
              sb.append(e).append(b);
          }else{
              return  "";
          }
        return  sb.toString();
    }

    @Test
    public void test(){
        String str ="abcdefg";

//        LeftRotateString(str,3);
        System.out.println( LeftRotateString(str,7));
    }

}
