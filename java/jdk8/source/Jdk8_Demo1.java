package com.coderpwh.code;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by 彭文浩 on 2017/12/13.
 */
public class Jdk8_Demo1 {

    public List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /**
     * 1.Lambda表达式
     */
    @Test
    public void testLambda() {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二：" + e));
    }

    /**
     * 2.Stream 流
     */
    @Test
    public void testStream(){
      List<Integer> list = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
         System.out.println("求和:"+list.stream().
                 filter(team ->team!=null)
                 .distinct()
                 .mapToInt(num->num*2)
                 .skip(2)
                 .limit(4)
                 .peek(System.out::println)
                 .sum());

    }

}
