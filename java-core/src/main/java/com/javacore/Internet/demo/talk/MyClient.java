package com.javacore.Internet.demo.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 30000);
        //启动客户端线程 接受服务器端消息并输出
        new Thread(new ClientThread(s)).start();
        //打开Socket对应的输出流 输送到服务器端
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            ps.println("有人说：" + line);
        }
    }

    private static class ClientThread implements Runnable {
        Socket s = null;
        BufferedReader br = null;

        public ClientThread(Socket s) throws IOException {
            this.s = s;
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }

        public void run() {
            String line = null;
            try {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
