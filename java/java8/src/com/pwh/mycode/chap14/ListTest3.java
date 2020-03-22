package com.pwh.mycode.chap14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author coderpwh
 * @create 2020-03-22 17:01
 * @desc ${DESCRIPTION}
 **/
public class ListTest3 {
    public static void main(String[] args) {
        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");

        Iterator<String> iterator = platformList.iterator();

        while (iterator.hasNext()) {
            String platform = iterator.next();
            if (platform.equals("博客园")) {
                iterator.remove();
            }
        }

        System.out.println(platformList);


    }
}
