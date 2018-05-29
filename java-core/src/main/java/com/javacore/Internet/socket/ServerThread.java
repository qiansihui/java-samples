package com.javacore.Internet.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 负责处理每个线程通信的线程类.
 */
public class ServerThread implements Runnable {
    //定义当前Socket
    Socket s = null;
    //Socket 对应的输入流
    BufferedReader bufferedReader = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }


    public void run() {
        try {
            String content = null;
            //循环从Socket中读取客户端发来的数据
            while ((content = readFromClient()) != null) {
                for (Socket s : MyServer.socketList) {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //定义读取客户端消息的方法
    private String readFromClient() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            MyServer.socketList.remove(s);
        }
        return null;
    }
}
