package com.javacore.Internet.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by qianqian on 2015/6/26.
 * 多线程通信服务端
 */
public class MyServer {
    public static ArrayList<Socket> socketList = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("服务器接收到请求：" + socket);
            socketList.add(socket);
            new Thread(new ServerThread(socket)).start();
        }
    }
}
