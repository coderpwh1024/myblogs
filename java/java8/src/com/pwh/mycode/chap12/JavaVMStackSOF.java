package com.pwh.mycode.chap12;

/**
 * @author coderpwh
 * @create 2020-03-12 12:55
 * @desc ${DESCRIPTION}
 **/
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();

    }
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        oom.stackLeak();
    }
}
