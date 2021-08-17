package com.wustzdy.spring.boot.leetcode.standard.algorithm.sort;

import java.util.Arrays;
//【排序】折半插入排序
public class HalfSearchSort {
    public void sort(int[] array) {
        int temp;

        for (int i = 1; i < array.length; i++) {
            int low = 0;
            int hight = i - 1;
            temp = array[i];

            while (hight >= low) {
                int mid = (low + hight) / 2;
                if (array[mid] > temp) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i - 1; j > hight; j--) {
                array[j + 1] = array[j];
            }

            array[hight + 1] = temp;

        }

    }

    public static void main(String[] args) {
        HalfSearchSort sort = new HalfSearchSort();
        int a[] = {8, 5, 4, 3, 2, 1, 6, 7};

        System.out.println("Before: " + Arrays.toString(a));
        //System.out.println(5/2);
        sort.sort(a);
        System.out.println("After: " + Arrays.toString(a));
    }
}
