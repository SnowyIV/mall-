package com.geekaca;

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
                        //todo:
                        /**
                         * 广播通知所有人
                         *
                         * 服务端要把当前在线的所有人昵称 都发一遍
                         * 用分割符号 分隔每个昵称，一次性发出去
                         */
                        StringBuilder stringBuilder = new StringBuilder();
                        ChatServer.onlineSocketMap.forEach(
                                (socket, nickName) -> {
                                    //把所有人的昵称连接起来
                                    /**
                                     * tom00&*^*&3197♣♣㏘♣④④♣jack00&*^*&3197♣♣㏘♣④④♣张三丰
                                     */
                                    stringBuilder.append(nickName).append(ChatConstant.SPLIT_STR);
                                }
                        );
                        ChatServer.onlineSocketMap.forEach((socket, nickName)->{
                            try {
                                dos.writeInt(ChatConstant.MSG_IN_ROOM);
                                dos.writeUTF(stringBuilder.toString());
                                dos.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
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
