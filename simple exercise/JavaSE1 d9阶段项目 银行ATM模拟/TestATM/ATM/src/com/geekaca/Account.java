package com.geekaca;

public class Account {
    private String cardId;
    private String userName;
    private String password;
    //余额
    private double money;

    //限额，每次最多只能取多少钱
    private double quotaMoney;

    public Account(String cardId, String userName, String password, double money, double quotaMoney) {
        this.cardId = cardId;
        this.userName = userName;
        this.password = password;
        this.money = money;
        this.quotaMoney = quotaMoney;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardId='" + cardId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", quotaMoney=" + quotaMoney +
                '}';
    }
}




