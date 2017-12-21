package com.coderpwh.misc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.regex.Pattern.compile;

/**
 * Created by coderpwh on 2017/12/21.
 */
public class String1 {
    public static void main(String[] args) {

//        testJoin();
//        testPatternSplit();
        testPatternPredicate();
    }

    private static void testChars(){

        String string = "foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c->String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());

        System.out.println(string);
    }

    private static void testPatternSplit(){

        String string = compile(":")
                .splitAsStream("foobar:foo:bar")
                .filter(s->s.contains("bar"))
                .sorted()
                .collect(Collectors.joining(":"));
        System.out.println(string);

    }

    private static  void testPatternPredicate(){
     long count = Stream.of("123@qq.com","456@qq.com")
             .filter(compile(".@qq\\.com").asPredicate()).count();
        System.out.println(count);

    }


    private static void testJoin(){
        String string = String.join(":","foobar","foo","bar");
        System.out.println(string);
    }


}
