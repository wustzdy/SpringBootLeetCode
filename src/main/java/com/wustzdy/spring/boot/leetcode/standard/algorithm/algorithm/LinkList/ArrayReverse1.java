package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

//已知在一位数组中A【m+n】中依次存放两个线性表(a1,a2,a3,....an),(b1,b2,b3...bn)是编写一个函数
//使(b1,b2,b3...bn)在(a1,a2,a3,....an)前面
public class ArrayReverse1 {
    public static void main(String[] args) {
        int arr[] = {7, 2, 3, 6, 10, 5};
        int left = 0;
        int right = 5;
        int length = 6;
        reverse(arr, left, right, length);
    }

    static void reverse(int arr[], int left, int right, int length) {
        int mid = (left + right) / 2;
        for (int i = 0; i < mid; i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }

        for (int j : arr) {
            System.out.print(j + ",");
        }
    }
}
