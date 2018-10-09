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

    public int length() {
        return 0;
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

    }

    /**
     * 出栈
     *
     * @return
     */
    public Object pop() {
        return null;
    }

    public void display() {
        Node p = top;
        if (p != null) {
            System.out.print((p.data.toString() + " "));
        }
        p = p.next;
    }

}
