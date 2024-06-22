package com.geekaca;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPServe {
    public static void main(String[] args) {
        try {
            //定义一个接口
            int port = 9999;
            System.out.println("服务器启动中..." + port);
            ServerSocket serverSocket = new ServerSocket(port);
            //阻塞等待别人的连接
            Socket socket = serverSocket.accept();
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            System.out.println("有连接"   +socketAddress);
            //读取发送来的数据
            InputStream ips = socket.getInputStream();
            //向对方发送数据
            OutputStream ops = socket.getOutputStream();
            PrintStream ps = new PrintStream(ops);
            ps.println("欢迎连接");
            ps.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            //固定套路 , 循环，不断的等待一个客户端发送数据来
            String line = null;
            while( (line = br.readLine()) != null ){
                System.out.println(socketAddress + " 说：" + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
