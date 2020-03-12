package com.pwh.mycode.chap12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coderpwh
 * @create 2020-03-12 12:36
 * @desc ${DESCRIPTION}
 **/
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            System.out.println("一旦要我开始，我就不会停止!");
            list.add(new OOMObject());
        }

    }
}
