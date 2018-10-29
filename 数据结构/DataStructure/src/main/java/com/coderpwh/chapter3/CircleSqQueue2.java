package com.coderpwh.chapter3;

/**
 * 循环顺序队列
 */
public class CircleSqQueue2 implements IQueue {


    private Object[] queueElem;

    // 队首
    private int front;

    // 队尾
    private int rear;

    public CircleSqQueue2(int maxSize) {
        front = rear = 0;
        queueElem = new Object[maxSize];
    }

    public void clear() {
        front = rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;

    }

    // 求队列的长度
    public int length() {
        return (front - rear + queueElem.length) % queueElem.length;
    }


    // 读取队首元素
    public Object peek() {
        if (front == rear) {
            return null;
        } else {
            return queueElem[front];
        }
    }

    // 入队操作
    public void offer(Object o) throws Exception {
        // 先判断对立是否已满
        if (front == (rear + 1) % queueElem.length) {
            throw new Exception("队列已满!");
        } else {
            queueElem[rear] = o;
            rear = (rear + 1) % queueElem.length;
        }
    }

    // 出队
    public Object poll() {
        // 先判断队列是否为空
        if (rear == front) {
            return null;
        }
        Object t = queueElem[front];
        front = (front + 1) % queueElem.length;
        return t;
    }

    // 遍历队列
    public void display() throws Exception {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % queueElem.length) {
                System.out.println(queueElem[i].toString());
            }
        } else {
            throw new Exception("此队列为空!");
        }
    }
}

