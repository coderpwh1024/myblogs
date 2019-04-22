package com.pwh.mycode.chap7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/22 11:11
 * 4
 */
public class ParallelStreams {

    public static void main(String[] args) {

    }


    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {

        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    /**
     * 并行流
     *
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }


    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }


}
