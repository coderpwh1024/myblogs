package com.coderpwh.code2;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 彭文浩 on 2017/12/17.
 */
public class Java8Test2 {

    public static void main(String[] args) {


        List<String> names = Arrays.asList("Ab","B","C","D");

        List<String> name = Lists.newArrayList("A","B","C","D");
/*
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {

                 return b.compareTo(a);
            }

        });*/

        // JDK8 Lambda 表达式
        Collections.sort(names,(String a,String b)->{
            return b.compareTo(a);
        });


       for (int i=0;i<names.size();i++){
           System.out.println(names.get(i));
       }









    }
}
