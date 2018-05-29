package com.javacore.inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ReadFromProcess {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //运行java命令 返回其子进程
            Process process = Runtime.getRuntime().exec("javac");
            //获取子进程的错误流
            br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String buff = null;
            while ((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
