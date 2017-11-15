package com.imooc.demo.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 彭文浩 on 2017/11/14.
 */
public class App {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("现在时间:"+sdf.format(date));

         date.setTime(date.getTime()+3000);
        System.out.println("现在时间是:"+sdf.format(date));
    }
}
