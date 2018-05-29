package com.javacore.inout;

import java.io.*;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class FileOutStreamTest {
    public void fileOutStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("README.md");
            fos = new FileOutputStream("hello.txt");
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buff)) > 0) {
                fos.write(buff, 0, hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWrite() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("hello.txt");
            fw.write("落霞与孤鹜齐飞，秋水共长天一色。");
            fw.write("山高月小，水落石出");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
//        new FileOutStreamTest().fileOutStream();
        new FileOutStreamTest().fileWrite();

    }
}
