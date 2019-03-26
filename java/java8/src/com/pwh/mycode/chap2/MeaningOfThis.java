package com.pwh.mycode.chap2;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/3/26 17:00
 * 4
 */
public class MeaningOfThis {


    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable runnable = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
