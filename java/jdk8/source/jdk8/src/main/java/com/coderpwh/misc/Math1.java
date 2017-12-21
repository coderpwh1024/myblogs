package com.coderpwh.misc;

/**
 * Created by coderpwh on 2017/12/21.
 */
public class Math1 {

    public static void main(String[] args) {
        testUnsignedInt();
        testMathExact();
    }


    private static void testUnsignedInt(){

        try {
             int i = Integer.parseUnsignedInt("-123",10);
            System.out.println("i:"+i);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
          // 11  右移32 位
        long maxUnsignedInt = (11<<32)-1;
        System.out.println(maxUnsignedInt);

        String string = String.valueOf(maxUnsignedInt);
        System.out.println(string);

        int unsignedInt = Integer.parseUnsignedInt(string,10);
        System.out.println(unsignedInt);

        System.out.println("= = = = = = = = = =");

        String string2 = Integer.toUnsignedString(unsignedInt,10);
        System.out.println(string2);

        try {
            Integer.parseInt(string,10);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("could not parset signed int of"+maxUnsignedInt);
        }
    }

    private  static  void testMathExact(){

        System.out.println(Integer.MAX_VALUE);

        System.out.println(Integer.MAX_VALUE+1);

        try {
            Math.addExact(Integer.MAX_VALUE,1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            Math.toIntExact(Long.MAX_VALUE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
