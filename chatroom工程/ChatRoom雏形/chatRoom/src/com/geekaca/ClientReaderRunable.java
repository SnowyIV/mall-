package com.geekaca;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ClientReaderRunable implements Runnable {
    private Socket socket;
    private String nickName;
    private ChatClient chatClient;
    public ClientReaderRunable(Socket socket, String nickName, ChatClient chatClient) {
        this.socket = socket;
        this.nickName = nickName;
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        //不断的读取对方的信息
        try (InputStream ips = this.socket.getInputStream();
             DataInputStream dis = new DataInputStream(ips);
             OutputStream ops = this.socket.getOutputStream();
        ) {
            //客户端连接上服务端后，第一件事情，就是把自己的昵称发送过去
            /**
             * 自定义通信协议设计：
             * 1， 有人进入房间
             * 	DataOutputStream writeInt(1)
             * 	writeUTF(昵称)
             */
            DataOutputStream dos = new DataOutputStream(ops);
            dos.writeInt(ChatConstant.MSG_IN_ROOM);
            dos.writeUTF(this.nickName);
            dos.flush();
            /**
             * 也是需要不断的读取来自服务端的消息
             */
            while (true) {
                int msgType = dis.readInt();
                switch (msgType) {
                    case ChatConstant.MSG_IN_ROOM:
                        String allUserNickNames = dis.readUTF();
                        String[] userNames = allUserNickNames.split(ChatConstant.SPLIT_STR);
                        System.out.println("在线用户:");
                        System.out.println(Arrays.toString(userNames) );

                        //客户端 刷新展示当前在线用户昵称列表
                        this.chatClient.onlineUsers.setListData(userNames);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
