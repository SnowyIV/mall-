package com.geekaca;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestFileList {
    public static void main(String[] args) {
        String directoryPath = "D:\\java\\9.8\\Test\\src\\com\\geekAca";
        List<String> javaList = new ArrayList<>();
        SearchFiles(directoryPath,javaList);
        for (String javaFile : javaList){
            System.out.println(javaFile);
        }
    }


    private static void SearchFiles(String directoryPath, List<String> javaList) {
        File dierectory = new File(directoryPath);
        File[] files = dierectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()&&file.getName().endsWith(".java")){
                    javaList.add(file.getAbsolutePath());
                }else if (file.isDirectory()){
                    SearchFiles(file.getAbsolutePath(), javaList);
                }
            }
        }
    }

}
