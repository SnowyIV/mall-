package com.geekaca;

import java.io.*;

//分别用FileXXXStream , BufferedXXXStream 实现文件的复制，比较两种方式的耗时
public class Compare {
    public static void main(String[] args) {
        //开始时间
        Long startTime1 = System.currentTimeMillis();
        // try/catch
        try {
            //BufferedXXXStream实现文件复制
            FileInputStream file1 = new FileInputStream(new File("1.txt"));
            FileOutputStream file2 = new FileOutputStream(new File("2.txt"));
            BufferedInputStream file3 = new BufferedInputStream(file1);
            BufferedOutputStream file4 = new BufferedOutputStream(file2);
            byte[] buf = new byte[64];
            int len = 0;
            while ((len = file3.read(buf)) != -1) {
                file2.write(buf, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //结束时间
        Long endTime1 = System.currentTimeMillis();
        //计算用时
        System.out.println("复制完毕,时间为" + (endTime1 - +startTime1));
        //开始时间
        Long startTime2 = System.currentTimeMillis();
        //创建文件
        File file = new File("D:\\java\\9.28\\3.txt");
        File copy = new File("D:\\java\\9.28\\4.txt");
        // try/catch
        try {
            //FileXXXStream实现文件复制
            FileInputStream file5 = new FileInputStream(file);
            FileOutputStream file6 = new FileOutputStream(copy);
            byte[] buf = new byte[64];
            int len = 0;
            while ((len = file5.read(buf)) != -1) {
                file6.write(buf, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //结束时间
        Long endTime2 = System.currentTimeMillis();
        //计算用时
        System.out.println("复制完毕,时间为" + (endTime2 - +startTime2));
    }
}
