package com.pwh.mycode.chap12;

/**
 * @author coderpwh
 * @create 2020-03-12 13:53
 * @desc ${DESCRIPTION}
 **/
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//
//        int i = 0;
//        while (true) {
//            System.out.println("--------Run");
//            list.add(String.valueOf(i++).intern());
//        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String st2 = new StringBuilder("ja").append("va1").toString();
        System.out.println(st2.intern() == st2);


    }
}
