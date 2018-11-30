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

    /**
     * 求队列长度
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
     * 读取队首元素
     *
     * @return
     */
    public Object peek() {
        if (front == null) {
            return null;
        } else {
            return front.data;
        }

    }

    /**
     * 出队
     *
     * @return
     */
    public Object poll() {
        if(front==null){
            return  null;
        }else{
            Node p = front;
            front = p.next;
            return  p.data;
        }
    }

    public void offer(Object o) throws Exception {

    }

    public void display() throws Exception {

    }
}
