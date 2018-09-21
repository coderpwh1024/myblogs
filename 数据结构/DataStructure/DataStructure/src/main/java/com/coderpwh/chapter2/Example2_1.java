package com.coderpwh.chapter2;

/**
 * 查找顺序表中第一次出现 字母为 z的下标
 */
public class Example2_1 {
    public static void main(String[] args) throws Exception {
        SqList sqList = new SqList(10);
        sqList.insert(0, 'a');
        sqList.insert(1, 'z');
        sqList.insert(2, 'd');
        sqList.insert(3, 'm');
        sqList.insert(4, 'z');

        int order = sqList.indexOf('z');
        if (order != -1) {
            System.out.println("顺序表中第一次出现的值为'z'的数据元素位置为:" + order);
        } else {
            System.out.println("顺序表中不包含值为'z'的数据元素");
        }
    }
}
