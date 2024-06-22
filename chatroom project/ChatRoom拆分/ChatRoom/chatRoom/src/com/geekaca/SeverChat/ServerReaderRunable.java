package com.geekaca.SeverChat;

import java.io.*;
import java.net.Socket;

public class ServerReaderRunable implements Runnable {
    private Socket clientSocket;

    public ServerReaderRunable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream ips = this.clientSocket.getInputStream();
             DataInputStream dis = new DataInputStream(ips);
             OutputStream ops = this.clientSocket.getOutputStream();
             DataOutputStream dos = new DataOutputStream(ops);
        ) {
            while (true) {
                int msgType = dis.readInt();
                switch (msgType) {
                    case ChatConstant.MSG_IN_ROOM:
                        String userNickName = dis.readUTF();
                        System.out.println(userNickName + " 进入房间...");
                        ChatServer.onlineSocketMap.put(clientSocket, userNickName);
                        break;
                    case ChatConstant.MSG_CHAT:
                        break;
                    default:
                        System.out.println("未知消息类型");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
