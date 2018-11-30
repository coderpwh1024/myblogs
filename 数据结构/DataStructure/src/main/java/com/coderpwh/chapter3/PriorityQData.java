package com.coderpwh.chapter3;

/**
 * 优先级队列结点
 */
public class PriorityQData {

    // 节点数据元素
    public Object elem;

    // 结点优先级
    public int priority;

    public PriorityQData(Object elem, int priority) {
        this.elem = elem;
        this.priority = priority;
    }
}
