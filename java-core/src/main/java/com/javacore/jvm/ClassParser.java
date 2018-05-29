package com.javacore.jvm;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author qianqian.sun
 * @Date 2018/2/11
 * 描述：
 */
public class ClassParser {

    public static void main(String[] args) throws IOException {
        String classFilePath = "target/classes/com/stu/jvm/TestClass.class";
        File file = new File(classFilePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1];
        fis.read(bytes);
        for (byte aByte : bytes) {
            System.out.println(Long.toString(aByte & 0xff, 2));
        }
//        DataInputStream dis = new DataInputStream(fis);
//        byte b = dis.readByte();
//        System.out.println(b);
        fis.close();
    }

}
