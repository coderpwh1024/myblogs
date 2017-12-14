package com.coderpwh.code;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by 彭文浩 on 2017/12/14.
 */
public class Jdk_Deom1 {

    public List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void testLambda() {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二：" + e));
    }


    /**
     * Stream函数式操作流元素集合
     */
    @Test
    public void testStream() {
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("求和：" + nums
                .stream()//转成Stream
                .filter(team -> team != null)//过滤
                .distinct()//去重
                .mapToInt(num -> num * 2)//map操作
                .skip(2)//跳过前2个元素
                .limit(4)//限制取前4个元素
                .peek(System.out::println)//流式处理对象函数
                .sum());//
    }

    @Test
    public void testDefaultFunctionInterface(){

    }

}
