package com.coderpwh.ch2;

/**
 * 线性表接口
 */
public interface Ilist {

    public void clear();

    public boolean isEmpty();

    public int length();

    public Object get(int i) throws Exception;

    public void insert(int i, Object x) throws Exception;

    public void remove(int i) throws Exception;

    public int indexOf(Object x);

    public void display();


}
