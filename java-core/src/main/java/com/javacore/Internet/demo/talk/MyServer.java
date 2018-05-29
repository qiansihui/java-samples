package com.javacore.Internet.demo.talk;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    //对应客户端Socket列表
    public static List<Socket> socketList = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        while (true) {
            Socket socket = serverSocket.accept();
            socketList.add(socket);
            new Thread(new ServerThread(socket)).start();
        }
    }

    private static class ServerThread implements Runnable {
        Socket s = null;
        BufferedReader br = null;

        public ServerThread(Socket socket) throws IOException {
            this.s = socket;
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }

        public void run() {
            try {
                String line;
                //循环从Socket中读取客户端发来的数据  发送给所有客户端
                while ((line = br.readLine()) != null) {
                    for (Socket s : MyServer.socketList) {
                        if (s != this.s) {
                            PrintStream ps = new PrintStream(s.getOutputStream());
                            ps.println(line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
