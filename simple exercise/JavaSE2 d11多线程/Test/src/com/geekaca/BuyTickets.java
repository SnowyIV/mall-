package com.geekaca;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyTickets {
    /**
     * 公共类
     */
    private int ticketNumber = 100;
    //lock锁
    private final Lock lock = new ReentrantLock();
    private int number;

    public BuyTickets() {

    }

    int buyingTickets(int ticketNumber) {
        //获取买票人的名字(名字是线程的名字)
        String name = Thread.currentThread().getName();
        lock.lock();
        if (this.ticketNumber >= ticketNumber) {
            this.number += 1;
            System.out.println(name + "成功购买" + ticketNumber + "张票。\t目前已购买：" + this.number + "张票。");
            this.ticketNumber -= ticketNumber;
            System.out.println(name + "这次购买后，仓库剩余：" + this.ticketNumber + "张票。");

        } else {
            System.out.println("票卖光了，" + name + "这次没有买到票。");
        }
        lock.unlock();
        return this.ticketNumber;

    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

