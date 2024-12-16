package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.sort;

import java.util.Arrays;

public class BubbleSort1 {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        bubbleSort(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        //外层循环控制比较次数
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < array.length - 1 - i; j++) {
                //比较前面的元素比后面元素大交换，同理也可以比较小
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
