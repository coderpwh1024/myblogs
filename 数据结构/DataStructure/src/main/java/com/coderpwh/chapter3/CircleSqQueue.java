 package com.coderpwh.chapter3;

/**
 * 顺序 队列
 *
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

    // 队列的长度
    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }


    /**
     * 获取队列的头元素
     *
     * @return
     */
    public Object peek() {
        if (front == rear) {
            return null;
        } else {
            return queueElem[front];
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public Object poll() {
        if (front == rear) {
            return null;
        } else {
            Object t = queueElem[front];
            front = (front + 1) % queueElem.length;
            return t;
        }
    }

    /**
     * 入队
     *
     * @param o
     * @throws Exception
     */
    public void offer(Object o) throws Exception {
        if ((rear + 1) % queueElem.length == front) {
            throw new Exception("队列已满");
        } else {
            queueElem[rear] = o;
            rear = (rear + 1) % queueElem.length;
        }

    }

    public void display() {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % queueElem.length) {
                System.out.println(queueElem[i].toString());
            }
        } else {
            System.out.println("此队列为空!");
        }
    }


    public Object[] getQueueElem() {
        return queueElem;
    }

    public void setQueueElem(Object[] queueElem) {
        this.queueElem = queueElem;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }


}
