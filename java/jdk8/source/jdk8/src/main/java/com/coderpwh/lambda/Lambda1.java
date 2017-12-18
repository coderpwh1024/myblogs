package com.coderpwh.lambda;

import com.beust.jcommander.internal.Lists;

import java.util.*;

/**
 * Created by coderpwh on 2017/12/18.
 */
public class Lambda1 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("abcd","bdea","efge","gfae");



        Collections.sort(names,new Comparator<String>(){

            @Override
            public int compare(String a, String b) {
                return b.compareTo(a) ;
            }
        });

         //  Lambda 表达式
        Collections.sort(names,(String a,String b)->{
            return  b.compareTo(a);
        });

      Collections.sort(names,(String a,String b)->b.compareTo(a));

       Collections.sort(names,(a,b)->b.compareTo(a));

        System.out.println(names);

         // 空值至于集合最后面
        List<String> list = Lists.newArrayList("A","B","C",null,"D","E");
        list.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(list);

        List<String> list2 = null;

        Optional.ofNullable(list2).ifPresent(li ->li.sort(Comparator.naturalOrder()));

        System.out.println(list2);












    }
}
