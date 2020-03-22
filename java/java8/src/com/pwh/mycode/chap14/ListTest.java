package com.pwh.mycode.chap14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coderpwh
 * @create 2020-03-22 16:01
 * @desc ${DESCRIPTION}
 **/
public class ListTest {

    public static void main(String[] args) {

        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");

        for (String platform : platformList) {
            if (platform.equals("博客园")) {
                platformList.remove("博客园");
            }
        }
        System.out.println(platformList);
    }
}
