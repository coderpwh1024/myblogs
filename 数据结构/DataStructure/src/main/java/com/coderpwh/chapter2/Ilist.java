package com.coderpwh.chapter2;

public interface Ilist {

    public void clear();

    public boolean isEmpty();

    public int length();

    public Object get(int i) throws Exception;

    public void insert(int i, Object x);

    public void remove(int i);

    public int indexOf(Object x);

    public void display();
}
