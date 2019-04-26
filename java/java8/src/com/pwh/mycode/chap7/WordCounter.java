package com.pwh.mycode.chap7;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/26 17:18
 * 4
 */
public class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }


    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);

        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }

    }


    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }


    public int getCounter() {
        return counter;
    }

    public boolean isLastSpace() {
        return lastSpace;
    }
}
