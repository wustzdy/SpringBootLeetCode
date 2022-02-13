package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

import static com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList.ArrayReverse2.exchange;

//字符串反转
public class ArrayReverse3 {
    public static void main(String[] args) {
        int arr[] = {7, 2, 3, 6, 10, 5};
        int m = 0;
        int n = 5;
        int length = 6;
        exchange(arr, m, n, length);
    }

    static void reverse(int arr[], int left, int right, int length) {
        int mid = (left + right) / 2;
        for (int i = 0; i <= mid - left; i++) {
            int temp = arr[left + i];
            arr[left + i] = arr[right - i];
            arr[right - i] = temp;
        }
        for (int i = left, j = right; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        for (int j : arr) {
            System.out.print(j + ",");
        }
    }

    static void reverse1(int arr[], int i, int j, int length) {

        for (; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        for (int p : arr) {
            System.out.print(p + ",");
        }
    }

    static void exchange(int arr[], int m, int n, int arraySize) {
        reverse1 (arr, 0, n, arraySize);
    }
}

/*
7, 2, 3, 6, 10, 5
5,10,6,3,2,7,---

10,5,6,3,2,7,---

10,5,7,2,3,6,*/