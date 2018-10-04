package com.coderpwh.ch2;

/**
 * 线性表接口
 */
public interface Ilist {

    public void clear();

    public boolean isEmpty();

    public int length();

    public Object get(int i);

    public void insert(int i, Object x);

    public void remove(int i);

    public int indexOf(Object x);

    public void display();


}
