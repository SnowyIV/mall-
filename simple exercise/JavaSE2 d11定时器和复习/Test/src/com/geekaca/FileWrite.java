package com.geekaca;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FileWrite {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        executorService.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime ldt = LocalDateTime.now();
                String date = ldt.format(dtf);
                try( FileWriter fileWriter = new FileWriter("test.txt",true)) {
                    BufferedWriter bw = new BufferedWriter(fileWriter);
                    bw.write(date);
                    bw.newLine();
                    bw.flush();
                    System.out.println("写出: " + date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0,30, TimeUnit.SECONDS);
    }
}
