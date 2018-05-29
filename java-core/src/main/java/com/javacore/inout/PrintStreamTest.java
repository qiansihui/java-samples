package com.javacore.inout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            //将被写入的文件
            FileOutputStream fos = new FileOutputStream("hello.txt");
            ps = new PrintStream(fos);
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }
}
