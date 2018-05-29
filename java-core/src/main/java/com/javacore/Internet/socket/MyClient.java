package com.javacore.Internet.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by qianqian on 2015/6/26.
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 30000);
        //启动客户端线程不断读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        //获取Socket对应的输出流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //不断读取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            ps.println(line);
        }
    }
}
