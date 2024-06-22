package com.geekaca;
//BufferedReader读取文件，输出内容
//增加 打印输出 当前是第几行

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        //创建file文件
        File file = new File("D:\\java\\9.28\\西游记.txt");
        //判断文件是否存在
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        //BufferedReader方法
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);) {
            String str = null;
            int len = 0;
            //读取每一行的内容并输出
            while ((str = br.readLine()) != null) {
                len++;
                System.out.println("第" + len + "行内容");
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
