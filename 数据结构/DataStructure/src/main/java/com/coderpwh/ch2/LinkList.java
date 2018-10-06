package com.coderpwh.ch2;

/**
 * 线性表类
 */
public class LinkList implements Ilist {

    // 单链表的头指针
    public Node head;

    public LinkList() {
        head = new Node();
    }


    public void clear() {
        head.next = null;
        head.data = null;
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


    public Object get(int i) throws Exception {
        // 初始化首结点
        Node p = head.next;
        int j = 0;
        while (p != null && j < i) {
            // 指向后续结点
            p = p.next;
            ++j;
        }
        if (p == null || j > i) {
            throw new Exception("第" + i + "个元素不存在!");
        }
        return p.data;
    }

    /**
     * 带头结点插入
     *
     * @param i
     * @param x
     * @throws Exception
     */
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;  // 带头结点插入
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (p == null || j > i - 1) {
            throw new Exception("插入的位置不合法!");
        }
        // 新节点
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;


    }

    /**
     * 不带头结点插入
     */
    public void insert2(int i, Object x) throws Exception {
        Node p = head;
        int j = 0;   // 此时无头结点
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (p == null || j > i) {
            throw new Exception("插入位置不合理");
        }
        // 创建新结点
        Node s = new Node(x);
        if (i == 0) {
            s.next = head;
            head = s;
        } else {
            s.next = p.next;
            p.next = s;
        }

    }


    /**
     * 删除操作
     *
     * @param i
     * @throws Exception
     */
    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        // 此时是要找到第i个结点的前驱结点
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (p.next == null || j > i - 1) {
            throw new Exception("删除的位置不合法!");
        }
        p.next = p.next.next;


    }

    /**
     * 按值查找
     *
     * @param x
     * @return
     */
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

    /**
     * 输出所有单链表中的所有结点
     */
    public void display() {
        Node node = head.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }
}
