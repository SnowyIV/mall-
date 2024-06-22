package com.geekaca;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicketPool implements Runnable {
    private static int ticket = 100;
    private static final Lock myLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                myLock.lock();
                if (ticket > 0) {
                    ticket--;
                } else {
                    break;
                }
            } finally {
                myLock.unlock();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 售出一张票 剩余票数: " + ticket);
    }
}





