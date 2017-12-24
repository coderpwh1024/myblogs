package com.coderpwh.stream;

import java.util.Optional;

/**
 * Created by 彭文浩 on 2017/12/24.
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();
        System.out.println(optional.isPresent());

        optional.get();
        System.out.println(optional.get());

        optional.orElse("fallback");
        System.out.println(optional.orElse("fallback"));




        optional.ifPresent((s) -> System.out.println(s.charAt(0)));





    }

}
