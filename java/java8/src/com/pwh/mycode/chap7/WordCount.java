 package com.pwh.mycode.chap7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/4/26 16:49
 * 4
 */
public class WordCount {

    public static final String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita " +
                    "mi  ritrovai in una  selva oscura" +
                    " che la  dritta via era   smarrita ";

    public static void main(String[] args) {

        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
        System.out.println("Found " + countWords(SENTENCE) + " words");
    }


    /**
     * 统计当前单词个数
     *
     * @param s
     * @return
     */
    private static int countWordsIteratively(String s) {
        int count = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    count++;
                }
                lastSpace = Character.isWhitespace(c);
            }

        }
        return count;
    }

    public static int countWords(String s) {
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        return countWords(stream);
    }


    private static int countWords(Stream<Character> stream) {

        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);

        return wordCounter.getCounter();

    }


}
