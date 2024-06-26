package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

//已知在一位数组中A【m+n】中依次存放两个线性表(a1,a2,a3,....an),(b1,b2,b3...bn)是编写一个函数
//使(b1,b2,b3...bn)在(a1,a2,a3,....an)前面
public class ArrayReverse2 {
    public static void main(String[] args) {
        int arr[] = {7, 2, 3, 6, 10, 5};
        int m = 4;
        int n = 2;
        int length = 6;
        exchange(arr, m, n, length);
    }

    static void reverse(int arr[], int left, int right, int length) {
        /*int mid = (left + right) / 2;
        for (int i = 0; i <= mid - left; i++) {
            int temp = arr[left + i];
            arr[left + i] = arr[right - i];
            arr[right - i] = temp;
        }*/
        for (int i = left, j = right; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        for (int j : arr) {
            System.out.print(j + ",");
        }
    }

    static void exchange(int arr[], int m, int n, int arraySize) {
        reverse(arr, 0, m + n - 1, arraySize);

        System.out.println("---");
        reverse(arr, 0, n - 1, n);

        System.out.println("---");
        reverse(arr, n, m + n - 1, m);
    }
}

/*
7, 2, 3, 6, 10, 5
5,10,6,3,2,7,---

10,5,6,3,2,7,---

10,5,7,2,3,6,*/
