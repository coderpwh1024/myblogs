package com.coderpwh.chapter3;

/**
 * 栈的实现类
 */
public class SqStack implements IStack {

    // 对象数组
    private Object[] stackElem;

    /**
     * 空栈时 top=0 ,非空时 指向栈顶的下一个元素
     */
    private int top;

    public SqStack(int maxSize) {
        top = 0;
        stackElem = new Object[maxSize];
    }

    /**
     * 栈为空
     */
    public void clear() {
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int length() {
        return top;
    }

    /**
     * 取栈顶元素
     *
     * @return
     */
    public Object peek() {

        if (!isEmpty()) {
            return stackElem[top - 1];
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
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stackElem[i].toString() + " ");
        }
    }

}
