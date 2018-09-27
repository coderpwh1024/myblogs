package com.coderpwh.chapter2;

import java.util.Scanner;

public class DuLinkList implements Ilist {

    public DuLNode head;

    public DuLinkList() {
        head = new DuLNode();
        head.prior = head;
        head.next = head;
    }

    public DuLinkList(int n) throws Exception {
        this();
        Scanner sc = new Scanner(System.in);
        for (int j = 0; j < n; j++) {
            insert(0, sc.nextInt());
        }
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

    public void insert(int i, Object x) throws Exception {
        DuLNode p = head.next;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.next;
            ++j;
        }
        if (j != i && !p.equals(head)) {
            throw new Exception("插入位置不合法!");
        }
        // 创建新节点
        DuLNode s = new DuLNode(x);
        p.prior.next = s;
        s.prior = p.prior;
        s.next = p;
        p.prior = s;

    }

    public void remove(int i) throws Exception {
        DuLNode p = head.next;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.next;
            ++j;
        }
        if (j != i) {
            throw new Exception("删除位置不合理!");
        }
        p.prior.next = p.next;
        p.next.prior = p.prior;

    }

    public int indexOf(Object x) {
        return 0;
    }

    public void display() {
        DuLNode node = head.next;
        while (!node.equals(head)) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }
}
