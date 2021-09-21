package com.wustzdy.spring.boot.leetcode.standard.algorithm.sort;

import java.util.Arrays;

//快速排序--standard
public class QuickSort3 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 8, 0, 5, 7, 1, 3, 9};
        quickSortFunction(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));

    }

    private static void quickSortFunction(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int temp = arr[start];
        if (i < j) {
            while (i < j) {
                while (i < j && arr[j] > temp) {
                    j--;
                }
                //判断，填坑
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < temp) {
                    i++;
                }
                //判断，填坑
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = temp;
            quickSortFunction(arr, start, i - 1);
            quickSortFunction(arr, i + 1, end);
        }
    }
}
