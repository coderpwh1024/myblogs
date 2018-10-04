package com.coderpwh.ch2;

/**
 * 线性表类
 */
public class LinkList implements Ilist {

    // 单链表的头指针
    public Node head;


    public LinkList(Node head) {
        this.head = head;
    }

    public void clear() {
        head.next = null;
        head.data = null
    }

    /**
     * 判断头结点是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 单链表长度
     *
     * @return
     */
    public int length() {
        Node p = head.next;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }


    public Object get(int i) {
        return null;
    }

    public void insert(int i, Object x) {

    }

    public void remove(int i) {

    }

    public int indexOf(Object x) {
        return 0;
    }

    public void display() {

    }
}
