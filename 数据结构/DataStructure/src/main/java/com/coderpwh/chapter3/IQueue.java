package com.coderpwh.chapter3;

/**
 * @author coderpwh
 * @version V1.0
 * @date 2018/10/16 11:26
 */
public interface IQueue {

    public void clear();

    public boolean isEmpty();

    public int length();

    public Object peek();

    public Object poll();

    public void offer(Object o) throws Exception;

    public void display();

}
