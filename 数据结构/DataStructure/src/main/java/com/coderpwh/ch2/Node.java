package com.coderpwh.ch2;

/**
 * 结点类
 */
public class Node {

    //  结点值
    public Object data;

    // 后续结点的引用
    public Node next;

    public  Node(){

    }

    public Node(Object data){
        this(data,null);
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
