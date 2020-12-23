package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {   // 这里说明为什么需要-1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    void BubbleSort(int a[], int len) {
        int i, j, temp;
        int flags = 0;
        for (j = 0; j < len - 1; j++) {
            for (i = 0; i < len - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flags = 1;//不是有序的，flags设置为1；
                }
            }
            if (flags == 0)
                return;
        }
    }

}
