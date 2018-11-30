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
        if (front == null) {
            return null;
        } else {
            Node p = front;
            front = p.next;
            return p.data;
        }
    }

    /**
     * 入队
     *
     * @param x
     * @throws Exception
     */
    public void offer(Object x) throws Exception {
        PriorityQData pn = (PriorityQData) x;
        // 新节点
        Node s = new Node(pn);
        // 空队列
        if (front == null) {
            front = rear = s;
        } else {
            Node p = front, q = front;
            // 新结点数据域值与队列结点的数据域相比较
            while (p != null && pn.priority >= ((PriorityQData) p.data).priority) {
                q = p;
                p = p.next;
            }
            if (p == null) {   // 插入队尾
                rear.next = s;
                rear = s;
            } else if (p == front) {  // 插入队首
                s.next = front;
                front = s;
            } else {           // 插入 队中
                q.next = s;
                s.next = p;
            }

        }


    }

    /**
     * 循环遍历
     *
     * @throws Exception
     */
    public void display() throws Exception {

    }
}
