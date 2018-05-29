package com.javacore.inout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class FileInputStreamTest {
    public void fileInputStream() {
        //创建字节输入流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("sys.txt");
            //创建长度为1024的桶
            byte[] buf = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buf)) > 0) {
                System.out.println(new String(buf, 0, hasRead) + "__end__");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void fileRead() {
        FileReader fr = null;
        try {
            //创建字符输入流
            fr = new FileReader("README.md");
            //创建32字符长度桶
            char[] buff = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(buff)) > 0) {
                System.out.println(new String(buff, 0, hasRead) + "---end---");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new FileInputStreamTest().fileRead();
    }
}
