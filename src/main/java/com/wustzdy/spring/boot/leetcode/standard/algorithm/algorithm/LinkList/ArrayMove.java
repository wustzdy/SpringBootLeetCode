package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

//将数组中所有小于表头元素的整数放在前半部分，大于表头元素的整数放在后半部分
public class ArrayMove {
    public static void main(String[] args) {
        int[] array = {2, 1, -7, -3, 5, 6, -1};
        moveElement(array);
        for (int element : array) {
            System.out.print(" " + element);
        }
    }

    private static void moveElement(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int temp;
        temp = array[i];
        while (i < j) {
            for (; i < j && array[j] > temp; j--) {

            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            for (; i < j && array[i] < temp; i++) {
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = temp;
    }
}
