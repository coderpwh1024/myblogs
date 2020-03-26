package com.pwh.mycode.chap16;

/**
 * @author coderpwh
 * @create 2020-03-26 15:02
 * @desc ${DESCRIPTION}
 **/
public class ThreadSafe extends Thread {

    public void run() {
        while (!isInterrupted()) {

            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
