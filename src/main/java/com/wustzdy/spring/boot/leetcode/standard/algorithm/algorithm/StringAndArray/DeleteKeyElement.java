package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.StringAndArray;

//删除线性表中所有值为x的数据元素
public class DeleteKeyElement {
    public static void main(String[] args) {
        int[] array = {3, 3, 4, 2, 5, 2};
        int key = 2;
        deleteKey(array, key);
    }

    private static void deleteKey(int[] array, int key) {
        int k = 0;//记录不等于key的元素的个数
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != key) {
                array[k] = array[i];
                k++;
            }
        }
        System.out.println("k:" + k);//k:4
    }
}
