package com.geekaca;

import java.io.*;

public class StrSearch {
    public static void main(String[] args) {
        Search();
    }


    private static void Search() {
        //创建所需查找的文件
        String SearchFile = "D:\\java\\9.28\\4448.txt";

        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(SearchFile);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);) {
            //读取文件的所有内容，用StringBuilder保存
            String str = null;
            int lineNumber = 1;
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str);
                System.out.println(lineNumber + ": " + str);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 在StringBuilder中搜索 孙悟空，猪八戒
        int cntSun = findStr(stringBuilder.toString(), "孙悟空");
        int cntZhu = findStr(stringBuilder.toString(), "猪八戒");
        System.out.println("西游记中 孙悟空出现次数：" + cntSun);
        System.out.println("西游记中 猪八戒出现次数：" + cntZhu);
    }


    private static int findStr(String line, String string) {
        int count = 0;
        int index = line.indexOf(string);
        while (index != -1) {
            count++;
            index = line.indexOf(string, index + 1);
        }
        return count;
    }
}
