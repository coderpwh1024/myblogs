package com.coderpwh.chapter2;

public class DuLinkList implements Ilist {

    /**
     * 双向链表头节点
     */
    private DuLNode head;

    public DuLinkList() {
        /***
         *   初始化头结点
         */
        head = new DuLNode();
        head.prior = head;
        head.next = head;
    }

    public void clear() {

    }

    public boolean isEmpty() {
        return false;
    }

    public int length() {
        return 0;
    }

    public Object get(int i) throws Exception {
        return null;
    }

    /**
     *
     * @param i
     * @param x
     * @throws Exception
     */
    public void insert(int i, Object x) throws Exception {
        /**
         *  p 则指向首节点
         */
        DuLNode p = head.next;
        int j = 0;
        /**
         * 寻找插入的位置i
         */
        while (!p.equals(head) && j < i) {
            p = p.next;
            ++j;
        }
        /**
         *  不合法的插入
         */
        if (!p.equals(head) && j != i) {
            throw new Exception("插入的位置不合法");
        }
        // 生产的新节点
        DuLNode s = new DuLNode(x);
        p.prior.next = s;
        s.prior = p.prior;
        s.next = p;
        p.prior = s;
    }

    public void remove(int i) throws Exception {

    }

    public int indexOf(Object x) {
        return 0;
    }

    public void display() {

    }
}
