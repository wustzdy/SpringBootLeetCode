package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//https://blog.csdn.net/dear_jia/article/details/108433718
//将数组中的元素循环左移p位，且要求时间和空间两方面尽可能高效
//问题描述：将n(n>1)个整数存放在一维数组R中，设计一个在时间和空间两方面都尽可能高效的算法。将R中保存的序列循环左移p(0<p<n)个位置，即将R中的数据(x0,x1,x2,...x(n-1))变换为(xp,x(p+1),...,x(n-1),x0,x1,...,x(p-1))。
//        算法设计思想：可以将线性表中前p个元素当成一个数组，第p+1到第n个元素当成一个数组，然后问题就转化为了将数组中的两个线性表位置互换，即，先将前半部分逆置，再将后半部分逆置，最后将整个表逆置（参见：数组中两线性表位置互换且空间复杂度为O(1)
public class ArrayBack {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15, 14, 13, 12, 11, 10};
        int[] resultArray = LeftMove(array, array.length, 5);
        for (int i : resultArray) {
            System.out.print(i + " ");
        }
    }

    private static int[] LeftMove(int[] array, int size, int p) {
        Reverse(array, 15, p);
        Reverse(array, p, size - 1);
        Reverse(array, 0, size - 1);
        return array;
    }

    private static int[] Reverse(int[] array, int left, int right) {
        //将顺序表中下标从left到right之间的元素逆置
        for (int i = 0; i <= (right - left) / 2; i++) {
            int temp = array[left + i];
            array[left + i] = array[right - i];
            array[right - i] = temp;
        }
        return array;
    }
}
