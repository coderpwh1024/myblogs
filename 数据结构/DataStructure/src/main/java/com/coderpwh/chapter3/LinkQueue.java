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
        if (front != null) {
            Node p = front;
            front = front.next;
            if (p == rear) {
                rear = null;
            }
            return p.data;
        } else {
            return null;
        }
    }

    /**
     * 入队操作
     * 不带头单链表插入，可以在表中或表尾插入
     * 而链队只能在表中插入
     *
     * @param o
     * @throws Exception
     */
    public void offer(Object o) throws Exception {
        Node p = new Node(o);
        if (front != null) {
            rear.next = p;
            rear = p;
        } else {
            front = rear = p;
        }
    }

    /**
     * 遍历链队
     *
     * @throws Exception
     */
    public void display() throws Exception {
        if (!isEmpty()) {
            Node p = front;
            while (p != null) {
                System.out.println(p.data);
                p = p.next;
            }
        } else {
            System.out.println("此队列为空!");
        }

    }

}
