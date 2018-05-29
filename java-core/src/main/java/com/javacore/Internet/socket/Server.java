package com.javacore.Internet.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        while (true) {
            Socket socket = serverSocket.accept();
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.print("我是墓地");
            printStream.close();
            printStream.flush();
        }
    }
}
