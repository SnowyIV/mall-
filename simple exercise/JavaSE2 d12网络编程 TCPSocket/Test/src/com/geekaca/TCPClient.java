package com.geekaca;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(Socket clientSocket = new Socket("127.0.0.1",9999);
            OutputStream ops = clientSocket.getOutputStream();
            PrintStream ps = new PrintStream(ops)) {
            System.out.println("client 连接 并发送信息");
            while(true){
                System.out.println("请输入");
                String input = scanner.next();
                ps.println(input);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
