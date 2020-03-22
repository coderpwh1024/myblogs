package com.pwh.mycode.chap14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author coderpwh
 * @create 2020-03-22 16:44
 * @desc ${DESCRIPTION}
 **/
public class ListTest2 {
    public static void main(String[] args) {

        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");

        Iterator var = platformList.iterator();

        while (var.hasNext()) {
            Object platform =  var.next();
            if (platform.equals("博客园")) {
                platformList.remove(platform);
            }
        }
        System.out.println(platformList);
    }
}
