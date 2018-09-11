package com.coderpwh.chapter2;

/**
 * 单向链表
 */
public class LinkList implements Ilist {

    // 单链表的头指针
    public Node head;

    public LinkList() {

    }

    public LinkList(int n, boolean Order) {
        this();
        if (Order) {
            create1(n);
        } else {
            create2(n);
        }
    }

    // 用尾插法顺序建立单链表，其中n为单链表的结点个数
    public void create1(int n) {

    }

    // 用头插法逆位顺序建立单链表，其中n为单链表的结点个数
    public void create2(int n) {

    }


    public void clear() {
        head.data = null;
        head.next = null;
    }

    // 判断带头结点的单链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    public int length() {
        Node p = head.next;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    public Object get(int i) throws Exception {

        // 初始化结点，p指向首结点，j为计数器
        Node p = head.next;
        int j = 0;
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }

        if (j > i || p == null) {
            throw new Exception("第" + i + "个元素不存在");
        }

        return p.data;
    }


    // 带头结点的单链表
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (j > i - 1 || p == null) {
            throw new Exception("插入位置不合法!");
        }
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;
    }

    public void insert2(int i, Object x) throws Exception {
        Node p = head;
        int j = 0;
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (j > i || p == null) {
            throw new Exception("插入位置不合理!");
        }
        Node s = new Node(x);
        // 表头位置
        if (i == 0) {
            s.next = head;
            head = s;
        } else {   // 表中或表末位置
            s.next = p.next;
            p.next = s;
        }


    }


    public void remove(int i) throws Exception {

    }

    public int indexOf(Object x) {
        Node p = head.next;
        int j = 0;
        while (p != null && !p.data.equals(x)) {
            p = p.next;
            ++j;
        }
        if (p != null) {
            return j;
        } else {
            return -1;
        }
    }


    // 输出单链表中所有的结点
    public void display() {
        Node node = head.next;
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
