package com.javacore.Internet.demo.talk;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: sunqianqian
 * @Date: 2015/6/29
 * @Description:
 * @CodeReviewer:
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(30000);
            while (true) {
                Socket socket = serverSocket.accept();
                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println("hello");
                ps.close();
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
