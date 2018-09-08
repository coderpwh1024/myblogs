package com.coderpwh.chapter2;

public class SqList implements Ilist {

    // 线性表存储空间
    private Object[] listElem;

    // 线性表的当前长度
    private int curLen;

    public SqList(int maxSie) {
        curLen = 0;
        listElem = new Object[maxSie];
    }

    public void clear() {

        curLen = 0;
    }

    // 判断线性表是否为空
    public boolean isEmpty() {
        return curLen == 0;
    }

    public int length() {
        return curLen;
    }

    public Object get(int i) throws Exception {
        if (i < 0 || i > curLen - 1) {
            throw new Exception("第" + i + "个元素不存在");
        }
        return listElem[i];

    }

    public void insert(int i, Object x) {

    }

    public void remove(int i) {

    }

    public int indexOf(Object x) {
        return 0;
    }

    public void display() {

    }
}
