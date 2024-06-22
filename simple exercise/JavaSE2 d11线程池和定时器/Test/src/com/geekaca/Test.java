package com.geekaca;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        pool.execute(new SellTicketPool());
        pool.execute(new SellTicketPool());
        pool.execute(new SellTicketPool());
        pool.execute(new SellTicketPool());

        pool.shutdown();
    }
}
