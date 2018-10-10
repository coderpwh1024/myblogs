package com.coderpwh.chapter3;

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




}
