package com.javacore.Internet.demo.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author: sunqianqian
 * @Date: 2015/6/30
 * @Description:
 * @CodeReviewer:
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 30000);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("服务器回应：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
