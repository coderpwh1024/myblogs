package com.coderpwh.chapter3;

/**
 * @author coderpwh
 * @version V1.0
 * @date 2018/10/16 16:06
 */
public class CircleSqQueue implements IQueue {

    // 队列存储空间
    private Object[] queueElem;

    // 队首的引用
    private int front;

    // 队尾的引用
    private int rear;


    public CircleSqQueue(int maxsize) {
        front = rear = 0;
        queueElem = new Object[maxsize];
    }

    // 队列职为空
    public void clear() {
        front = rear = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }

    public Object peek() {
        return null;
    }

    public Object poll() {
        return null;
    }

    public void offer(Object o) throws Exception {

    }

    public void display() {

    }
}
