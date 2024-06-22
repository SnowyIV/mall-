package com.geekaca;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        /**
         * 数据发送方
         *  网络程序
         *  占据 6666 端口
         *  进行数据发送
         *
         *  发送端口和接收端口 之间没有关系
         *  发送port：  指的是 发送方占据本机的哪个端口
         *
         *  接收端口，目的地端口：    接收方（服务端） 端口
         */

        DatagramSocket socketClient = new DatagramSocket(6666);
        String str = "你好UDP世界";
        //String转变成字节数组 byte[]  来发送
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //装进 数据包中 发送
        /**
         public DatagramPacket(byte buf[], int length,
         InetAddress address, int port)
         参数一：封装要发送的数据（要快递发送的鞋子）
         参数二：发送数据的大小
         参数三：目的地的地址   服务端的主机IP地址     省市区小区楼
         参数四：destination 目的地 的port 服务端的端口    具体哪一家  门牌号码
         */
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),
                8888);
        socketClient.send(packet);
        socketClient.close();
    }
}
