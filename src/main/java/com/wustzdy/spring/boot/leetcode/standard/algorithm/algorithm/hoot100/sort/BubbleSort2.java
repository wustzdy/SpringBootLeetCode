package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.sort;

import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        bubbleSort2(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    //减少一些可能循环的次数
    public static void bubbleSort2(int[] numbers) {
        //外层循环控制比较次数
        for (int i = 0; i < numbers.length - 1; i++) {

            int flag = 0;//默认标记为0
            //内层循环控制到达位置
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                //比较前面的元素比后面元素大交换，同理也可以比较小
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    flag = 1;//如果还有交换，标记为1
                }
            }

            if (flag == 0) {//如果没有交换过的元素，则已经有序了
                return;
            }
        }
    }
}
