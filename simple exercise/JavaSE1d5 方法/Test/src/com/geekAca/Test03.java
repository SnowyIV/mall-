package com.geekAca;


//判断任意两个整型数组是否一样并返回ture或者false
public class Test03 {
    public static void main(String[] args) {
        int arr1[] = {11, 22, 33, 44, 55};
        int arr2[] = {11, 22, 33, 44, 55};
        boolean ispd = isPd(arr1, arr2);
        System.out.println("整型数组是否一样?" + ispd);
    }


    public static boolean isPd(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
