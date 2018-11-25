package com.coderpwh.chapter2;

public class SqList implements Ilist {

    // 线性表存储空间
    private Object[] listElem;

    // 线性表的当前长度
    private int curLen;

    public SqList(int maxSie) {
        curLen = 0;
        listElem = new Object[maxSie];
//        curLen = maxSie;
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

    // 顺序表插入
    public void insert(int i, Object x) throws Exception {

        if (curLen == listElem.length) {
            throw new Exception("顺序表已经满");
        }
        if (i < 0 || i > curLen) {
            throw new Exception("插入的位置不合法");
        }
        for (int j = curLen; j > i; j--) {
            listElem[j] = listElem[j - 1];
            listElem[i] = x;
            curLen++;
        }
    }

    public void remove(int i) throws Exception {

        if (i < 0 || i > curLen) {
            throw new Exception("删除位置不合法");
        }
        for (int j = i; j < curLen - 1; j++) {
            listElem[j] = listElem[j + 1];
            curLen--;
        }

    }

    public int indexOf(Object x) {
        int j = 0;
        while (j < curLen && !listElem[j].equals(x)) {
            j++;
        }
        if (j < curLen) {
            return j;
        } else {
            return -1;
        }
    }

    public void display() {

    }
}
