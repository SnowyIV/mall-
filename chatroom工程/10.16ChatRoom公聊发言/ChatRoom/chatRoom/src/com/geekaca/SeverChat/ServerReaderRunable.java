package com.geekaca.SeverChat;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            //不断读取客户端信息
            while (true) {
                int msgType = dis.readInt();
                switch (msgType) {
                    case ChatConstant.MSG_IN_ROOM:
                        String userNickName = dis.readUTF();
                        System.out.println(userNickName + " 进入房间...");
                        ChatServer.onlineSocketMap.put(clientSocket, userNickName);
                        //广播通知所有人
                        StringBuilder stringBuilder = new StringBuilder();
                        ChatServer.onlineSocketMap.forEach(
                                (socket, nickName) -> {
                                    stringBuilder.append(nickName).append(ChatConstant.SPLIT_STR);
                                });
                        ChatServer.onlineSocketMap.forEach((socket, nickName) -> {
                            //指向集合中的每个元素，打开每个客户端的输出流，发送给每个客户端
                            try {
                                DataOutputStream dos2 = new DataOutputStream(socket.getOutputStream());
                                dos2.writeInt(ChatConstant.MSG_IN_ROOM);
                                dos2.writeUTF(stringBuilder.toString());
                                dos2.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case ChatConstant.MSG_CHAT:
                        //收到有人发言并广播
                        String msgContent = dis.readUTF();
                        System.out.println("收到用户" + this.clientSocket + "发言：" + msgContent);
                     sendMsgToAll(msgContent);
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
    private void sendMsgToAll(String msgContent){
        //遍历访问Map集合，用输出流逐一发送，广播给每个客户端
        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String nowStr = now.format(dtf);
        ChatServer.onlineSocketMap.forEach((socket, nickName) ->{
            String chatNickName = ChatServer.onlineSocketMap.get(this.clientSocket);
            stringBuilder.append(nowStr).append("\r\n").append(chatNickName).append(":").append(msgContent);

            try {
                OutputStream ops2 = socket.getOutputStream();
                DataOutputStream dos2 = new DataOutputStream(ops2);
                dos2.writeInt(ChatConstant.MSG_CHAT);
                dos2.writeUTF(stringBuilder.toString());
                dos2.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );
    }
}
