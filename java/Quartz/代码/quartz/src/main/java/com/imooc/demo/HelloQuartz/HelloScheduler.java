package com.imooc.demo.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 彭文浩 on 2017/11/26.
 */
public class HelloScheduler {
    public static void main(String[] args) {

        // 当前时间

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is : " + sdf.format(date));





    }

}
