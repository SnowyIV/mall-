package com.geekaca;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ChatServer {
    public static final Map<Socket, String> onlineSocketMap = new HashMap<>();
    //创建线程池
    private ExecutorService pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        new ChatServer().startServer();
    }


    private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(ChatConstant.Port);
            System.out.println("=====服务器启动：" + ChatConstant.Port + "=====");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("收到连接：" +socket.getRemoteSocketAddress());
                pool.execute(new ServerReaderRunable(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
