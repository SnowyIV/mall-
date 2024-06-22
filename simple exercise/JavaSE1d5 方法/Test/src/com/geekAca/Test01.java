package com.geekAca;

public class Test01 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44};
        print(arr);
    }


    public static void print(int[] arr) {
        if (arr == null) {
            System.out.println("数组为null");
        } else {
            String str = "该数组内容为:[";
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    str += (arr[i]);
                } else {
                    str += (arr[i] + ", ");
                }
            }
            str += "]";
            System.out.println(str);
        }
    }
}