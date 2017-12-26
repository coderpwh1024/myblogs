package com.coderpwh.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by coderpwh on 2017/12/26.
 */
public class Stream4 {
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            if(i%2==1){
                System.out.print(i+" "); // 奇数
            }
        }
        System.out.println();
        System.out.println("= = = = = = = = = =  = = = ");


        IntStream.range(0,10)
                .forEach(i->{
                if(i%2==1){
                    System.out.print(i+" ");
                }
                });

        System.out.println();
        System.out.println("= = = = = = = = = =  = = = ");

        IntStream.range(0,10)
                .filter(i->i%2 ==1)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("= = = = = = = = = =  = = = ");

        OptionalInt  reduce1 =  IntStream.range(0,10)
               .reduce((a,b)->a+b);
        System.out.println(reduce1.getAsInt());

        System.out.println();
        System.out.println("= = = = = = = = = =  = = = ");

        // reduce方法内2值参加
        int reduced2  =
                IntStream.range(0,10)
                .reduce(7,(a,b) ->a+b);    // 52

        System.out.println(reduced2);









    }
}
