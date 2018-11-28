package com.coderpwh.chapter3;

import com.coderpwh.ch2.Node;

/**
 * 优先级队列
 */
public class PriorityQueue implements IQueue {

    // 队首
    private Node front;

    // 队尾
    private Node rear;

    // 构造函数
    public PriorityQueue() {
        front = rear = null;
    }

    public void clear() {
        front = rear = null;

    }

    public boolean isEmpty() {
        return front == null;
    }

    public int length() {
        return 0;
    }

    public Object peek() {
        return null;
    }

    public Object poll() {
        return null;
    }

    public void offer(Object o) throws Exception {

    }

    public void display() throws Exception {

    }
}
