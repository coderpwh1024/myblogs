package com.coderpwh.chapter3;

import com.coderpwh.ch2.Node;

/**
 * 链栈
 */
public class LinkStack implements IStack {

    /**
     * 栈顶元素
     */
    private Node top;


    public void clear() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 栈链的长度
     *
     * @return
     */
    public int length() {
        Node p = top;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    /**
     * 取栈顶元素
     *
     * @return
     */
    public Object peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            return null;
        }
    }

    /**
     * 入栈
     *
     * @param x
     * @throws Exception
     */
    public void push(Object x) throws Exception {
        Node p = new Node(x);
        p.next = top;
        top = p;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Object pop() {
        if (isEmpty()) {
            return null;
        } else {
            // 栈顶元素
            Node p = top;
            top = top.next;
            return p.data;

        }
    }

    public void display() {
        Node p = top;
        if (p != null) {
            System.out.print((p.data.toString() + " "));
        }
        p = p.next;
    }

}
