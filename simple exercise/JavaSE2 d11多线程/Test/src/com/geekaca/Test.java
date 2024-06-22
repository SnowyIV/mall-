package com.geekaca;

public class Test {
    public static void main(String[] args) {
        String str = "Mylock";

        for (int i = 1; i < 10; i++) {
            Seller seller = new Seller(str);
            seller.start();
        }
    }
}
