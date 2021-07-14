package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

/*
 * 11.在数组{1,2,3,4,6,7,9,8,10}中插入一个数5，
 * 使其插入完成后仍然有序，运行结果如下：
 */
public class insertSort {
    public static void main(String[] args) {
        int a = 4;
        int b = 0;//用于纪录需要插入数字的下标
        int[] array = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println("原来的数组为：");
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
        //找下标，并用b纪录
        for (int i = 0; i < array.length - 1; i++) {
            if (a < array[i]) {
                b = i;
                break;
            }

        }
        //定义一个新数组，大于下标的数后移一位
        int[] newarr = new int[array.length + 1];
        for (int i = newarr.length - 1; i >= 0; i--) {
            if (i > b) {        //当数组下标比插入数的下标大时，后移一位
                newarr[i] = array[i - 1];
            } else if (i == b) {    //下标相等时赋值
                newarr[i] = a;

            } else if (i < b) {    //数组下标比插入数下标小，相等赋值
                newarr[i] = array[i];
            }
        }
        System.out.println("插入后的数组：");
        for (int i : newarr) {
            System.out.print(i + ", ");
        }
    }
}
