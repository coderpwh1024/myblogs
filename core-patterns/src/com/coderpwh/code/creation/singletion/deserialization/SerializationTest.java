package com.coderpwh.code.creation.singletion.deserialization;

import java.io.*;

/**
 * @author coderpwh
 * @create 2019-08-19 22:24
 * @desc ${DESCRIPTION}
 **/
public class SerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DemoSingleton instanceOne = DemoSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // 从文件反序列化到对象
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
    }
}
