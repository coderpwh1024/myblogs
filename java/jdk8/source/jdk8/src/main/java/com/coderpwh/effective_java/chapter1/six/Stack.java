package com.coderpwh.effective_java.chapter1.six;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author coderpwh
 * @Date: 2018/2/1.
 * @Description:
 */
public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {

    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 清空过期引用
     *
     * @return
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }


}
