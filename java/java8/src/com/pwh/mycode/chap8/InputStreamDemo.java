package com.pwh.mycode.chap8;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamDemo {
    public static final char [] exit = new char[] {'e','x','i','t','\n'};
    public static boolean exitCommand(char [] chars,int len){
        if(len != 5){
            return false;
        }
        boolean isExit = true;
        for(int i=0;i<5;i++){
            if(chars[i]!=exit[i]){
                isExit = false;
                break;
            }
        }
        return isExit;
    }
    public static void cleanCharsBlock(char[] chars){
        for(int x=0;x<chars.length;x++){
            chars[x] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("【---请输入文本---】");
        System.out.print("shell@bash > ");
        InputStreamReader reader = new InputStreamReader(System.in);
        char [] chars = new char[8];
        StringBuffer stringBuffer = new StringBuffer();
        boolean stop = false;

        while (true){
            stringBuffer.append("jeanbean@mint > ");
            while (true){
                int len = reader.read(chars);
                stringBuffer.append(chars,0,len);
                if(len<chars.length || chars[len-1] == '\n'){
                    if(exitCommand(chars,len)){
                        reader.close();
                        stop = true;
                    }
                    break;
                }
            }
            if(stop){
                stringBuffer.delete(0,stringBuffer.length());
                System.out.println("Exit , Bye bye!");
                break;
            }
            System.out.print(stringBuffer);
            stringBuffer.delete(0,stringBuffer.length());
            cleanCharsBlock(chars);
            System.out.print("shell@bash > ");
        }
    }
}
