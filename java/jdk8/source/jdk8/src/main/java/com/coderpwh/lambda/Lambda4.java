package com.coderpwh.lambda;

/**
 * Created by coderpwh on 2017/12/19.
 */

public class Lambda4 {

    static  int outerStaticNum;

    int outerNum;

     void  testScopes(){
         int num =1;
        Lambda2.Converter<Integer,String> stringConverter = (from) -> String.valueOf(from+num);
        String convert = stringConverter.convert(2);
         System.out.println(convert);

         Lambda2.Converter<Integer,String> stringConverter2 = (from) ->{
             outerNum = 13;
             return String.valueOf(from);
         };

         String[] array = new String[1];
         Lambda2.Converter<Integer,String> stringConverter3 = (from)->{
             array[0] = "Hi there";
             return String.valueOf(from);
         };
         stringConverter3.convert(23);
         System.out.println(array[0]);

     }

    public static void main(String[] args) {

         new Lambda4().testScopes();
     }



}
