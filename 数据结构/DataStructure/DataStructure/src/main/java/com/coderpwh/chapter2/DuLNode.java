package com.coderpwh.chapter2;

/**
 * 双向链表结点
 */
public class DuLNode {
    public Object data;
    public DuLNode prior;
    public DuLNode next;

    public DuLNode() {
        this(null);
    }

    public DuLNode(Object data) {
        this.data = data;
        this.prior = null;
        this.next = null;
    }
}
