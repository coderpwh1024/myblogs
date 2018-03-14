package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/9.
 * @Description:
 */

import org.testng.annotations.Test;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Demo14 {

    /**
     * student. a am I
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {

        if (str == null || str.length() < 2) {
            return str;
        }
        char[] array = str.toCharArray();
        resever(array, 0, array.length - 1);
        int start = 0;
        int end = 0;
        while (start < array.length) {
            if (array[end] != ' ') {
                if (end == array.length - 1) {
                    resever(array, start, end);
                }
                end++;
            } else if (array[end] == ' ') {
                resever(array, start, end - 1);
                end++;
                start = end;
            }
        }
        return String.valueOf(array);
    }

    private void resever(char[] array, int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }


    @Test
    public void test() {
        String str = " 1";
        ReverseSentence(str);
        System.out.println(ReverseSentence(str));
    }

}
