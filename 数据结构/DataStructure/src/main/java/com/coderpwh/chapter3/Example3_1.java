package com.coderpwh.chapter3;

import java.util.Scanner;

/**
 * 分隔符匹配问题
 */
public class Example3_1 {
    /**
     * 记录 左右，其他分隔符
     */
    private final int LEFT = 0;
    private final int RIGHT = 1;
    private final int OTHER = 2;


    /**
     * 判断分隔符类型
     *
     * @param str
     * @return
     */
    public int verifyFlag(String str) {
        if ("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)) {
            return LEFT;
        } else if (")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)) {
            return RIGHT;
        } else {
            return OTHER;
        }
    }

    /**
     * 左右分隔符是否匹配
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean matches(String str1, String str2) {
        if (("(".equals(str1) && ")".equals(str2)) || ("[".equals(str1) && "]".equals(str2)) || ("{".equals(str1) && "}".equals(str2))) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isLegal(String str) throws Exception {
        if (!"".equals(str) && str != null) {
            SqStack S = new SqStack(100);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                String t = String.valueOf(c);
                if (i != length) {
                    if (('/' == c && '*' == str.charAt(i + 1)) || ('*' == c && '/' == str.charAt(i + 1))) {
                        t = t.concat(String.valueOf(str.charAt(i + 1)));
                        ++i;
                    }
                }
                // 左分隔符
                if (LEFT == verifyFlag(t)) {
                    S.push(t);
                } else if (RIGHT == verifyFlag(t)) {
                    if (S.isEmpty() || !matches(S.pop().toString(), t)) {
                        throw new Exception("错误:Java语句不合法!");
                    }
                }
            }
            if (!S.isEmpty()) {
                throw new Exception("错误:java语句不合法!");
            }
            return true;
        } else {
            throw new Exception("错误:java语句不合法!");
        }

    }

    public static void main(String[] args) throws Exception {
        Example3_1 e = new Example3_1();
        System.out.println("请输入分java语句:");
        Scanner sc = new Scanner(System.in);
        if(e.isLegal(sc.nextLine())){
            System.out.println("Java语句合法!");
        }else{
            System.out.println("错误:Java语句不合法!");
        }
    }


}
