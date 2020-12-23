package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] result = selectSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 找出最小值得元素下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;

    }
}
