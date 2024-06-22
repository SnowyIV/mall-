package com.geekaca;
//利用try-with-resource 加IO 实现文件的复制，mp3, png/jpg, mp4

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        TestReadFile();
    }

    //定义方法
    private static void TestReadFile() {
        //创建file变量
        File file = new File("D:\\java\\9.27\\1.txt");
        File copy = new File("D:\\java\\9.27\\2.txt");

// try/catch
        try {
            //读取
            FileInputStream fis = new FileInputStream(file);
            //输出
            FileOutputStream fos = new FileOutputStream(copy);
            //字节数组
            byte[] buffer = new byte[1024];
            int length = 0;
            //判断是否还有数据
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
                System.out.println(+length);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
