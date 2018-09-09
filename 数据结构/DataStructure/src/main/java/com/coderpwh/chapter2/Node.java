package com.coderpwh.chapter2;

/**
 *   结点类
 */
public class Node {
    public Object data;

    public Node next;

    // 无惨构造函数
    public Node() {
        this(null, null);
    }

    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }


}
