package com.wustzdy.spring.boot.leetcode.standard.algorithm.sort;

import java.util.Arrays;

public class InsertSortTest {
    public static void main(String[] args) {
        int array[] = {49, 38, 65, 13};
        insertSortFunction(array);
    }

    private static void insertSortFunction(int[] array) {
        int temp;
        int i, j;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
