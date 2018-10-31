package com.coderpwh.chapter3;

import com.coderpwh.ch2.Node;

/**
 * 链队
 */
public class LinkQueue implements IQueue {

    // 队首指针
    private Node front;

    // 队尾指针
    private Node rear;

    // 无惨构造
    public LinkQueue() {
        front = rear = null;
    }

    public void clear() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    /**
     * 求队列的长度
     *
     * @return
     */
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    /**
     * 队首元素
     *
     * @return
     */
    public Object peek() {
        if (front != null) {
            return front.data;
        } else {
            return null;
        }
    }

    /**
     * 出队操作
     *
     * @return
     */
    public Object poll() {
        return null;
    }

    /**
     * 入队操作
     *
     * @param o
     * @throws Exception
     */
    public void offer(Object o) throws Exception {

    }

    public void display() throws Exception {

    }

}
