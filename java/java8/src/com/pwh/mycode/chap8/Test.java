package com.pwh.mycode.chap8;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author coderpwh
 * @create 2019-07-20 0:22
 * @desc ${DESCRIPTION}
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("【---请输入文本---】");
        InputStreamReader reader = new InputStreamReader(System.in);
        char [] chars = new char[1024];
        int len=0;
        while (true){
            while ((len=reader.read(chars))!=-1){
                String str=new String(chars,0,len);
                System.out.println(str.contains("exit"));
                if(str.contains("exit")){
                    System.out.println("结束!");
                    System.exit(1);

                }
                System.out.println(str);
            }

        }



    }
}
