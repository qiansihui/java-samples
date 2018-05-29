package com.javacore.inout;

import java.io.*;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class KeyinTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            FileOutputStream fos = new FileOutputStream("hello.txt");
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            bw = new BufferedWriter(writer);
            InputStreamReader reader = new InputStreamReader(System.in);
            br = new BufferedReader(reader);
            String buffer = null;
            while ((buffer = br.readLine()) != null) {
                if (buffer.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容为：" + buffer);
                bw.write(buffer);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
