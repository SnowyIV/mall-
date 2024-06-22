package com.geekaca;
//搜索文本文件内容中，是否包含某个字符串
//西游记.txt ，从中搜索 猪八戒，孙悟空，比较 提到谁的次数更多？

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSearchStr {
    public static void main(String[] args) {
        //创建file文件
        File file = new File("D:\\java\\9.28\\西游记.txt");
        //判断是否存在这个文件
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        //try/catch
        try (FileReader fr = new FileReader(file)) {
            char[] buf = new char[3];
            int len = 0;
            int scount = 0;
            int zcount = 0;
            //判断有内容持续输出
            while ((len = fr.read(buf)) != -1) {
                String str = new String(buf, 0, len);
                //判断孙悟空出现次数
                if (str.equals("孙悟空")) {
                    scount++;
                }
                //判断猪八戒出现次数
                if (str.equals("猪八戒")) {
                    zcount++;
                }
                System.out.println(str);
            }
            System.out.println("孙悟空提及次数：" + scount + ",猪八戒提及次数：" + zcount);
            //判断谁出现次数多
            if (scount > zcount) {
                System.out.println("孙悟空提及次数多");
            }
            if (zcount > scount) {
                System.out.println("猪八戒提及次数多");
            }
            if (scount == zcount) {
                System.out.println("一样多");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
