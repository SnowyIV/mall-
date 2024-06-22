package com.geekaca;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟销售窗口
 */
public class Seller extends Thread {
    //总票数
    private static int ticket = 100;
    private String lock;
    //成员变量  类似于每个人都有自己的电话亭，每个对象锁自己的，相互间并不会互斥
//    private  final Lock myLock = new ReentrantLock();
    //static 在类的多个对象间共享
    private static final Lock myLock = new ReentrantLock();

    public Seller(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        //this 是指向当前线程对象
        //锁的区域太大，所有票都被一个人卖光了
//        synchronized (this.lock) {
        while (true) {
            //可以锁定共享资源，但是锁比较重
//            synchronized (this.lock) {

            try {
                myLock.lock();
                if (ticket > 0) {
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + " 销售1张票，剩余: " + ticket);
                    //                try {
                    //                    Thread.sleep(2);
                    //                } catch (InterruptedException e) {
                    //                    e.printStackTrace();
                    //                }

                } else {
                    break;
                }
            } finally {
                myLock.unlock();
            }

//            }
        }
//        }
    }
}
