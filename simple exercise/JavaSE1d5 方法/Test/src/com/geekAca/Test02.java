package com.geekAca;


import java.util.Scanner;

//需求：设计一个方法可以接受整型数组，和要查询的元素值；最终要返回元素在该数组中的索引，如果数组中不含该元素则返回-1；
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的元素值");
        int num = scanner.nextInt();
        int arr[] = {11, 22, 33, 44};
        int cf = find(arr, num);
        System.out.println("返回元素在该数组中的索引" + cf);
    }


    public static int find(int[] arr, int num) {
        if (arr == null) {
            System.out.println("数组不符合规定");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (num == arr[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}





