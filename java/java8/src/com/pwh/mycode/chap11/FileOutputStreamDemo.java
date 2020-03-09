package com.pwh.mycode.chap11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author coderpwh
 * @create 2020-02-27 13:39
 * @desc ${DESCRIPTION}
 **/
public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";

        byte buf[] = source.getBytes();
        OutputStream fo = new FileOutputStream("file.txt");

        for (int i = 0; i < source.length(); i += 2) {
            fo.write(buf[i]);
        }
        fo.close();

        OutputStream f1 = new FileOutputStream("file2.txt");
        f1.write(buf);
        f1.close();

        OutputStream f2 = new FileOutputStream("file3.txt");
        f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        f2.close();



    }
}
