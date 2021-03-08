package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//顺序表逆置，链表逆置
//顺序表逆置真题：
//
//1.将一长度为n的数组的前端k(k<n)}个元素逆置后移动到数组后端，要求原数组中数据不丢失;
//
//2.将一长度为n的数组的前端k(k<n)个元素保持原序移动到数组后端，要求原数组中数据不丢失;
//
//3.将数组中的元素(Xo, X1, ... Xn-1)，经过移动后变为:(Xp, Xp+1, ...Xn-1, Xo, X1, ..Xp-1) ，即循环左移p(0<p<n)个位置。

//https://blog.csdn.net/weixin_43574050/article/details/105036639
public class StringLeftRetote1 {
    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int p = 5;
        reverse(array, 0, array.length-1, p);////逆置前P
        for (int i : array) {
            System.out.print(i + ",");
        }
    }

    /*参数说明：
        a[]:要改变的数组
       left:左边起点
      right:右边终点
          k:要移动的元素个数*/
    static void reverse(int a[], int left, int right, int k) {
        int temp;
        for (int i = left, j = right; i < left + k && i < j; ++i, --j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    //第二题
    void moveToEnd(int a[], int n, int k) {
        reverse(a, 0, k - 1, k); //reverse函数为第一题中的
        reverse(a, 0, n - 1, k);
    }


    //第三题
    static void moveP(int a[], int n, int p) {
        reverse(a, 0, p - 1, p);
        reverse(a, p, n - 1, n - p);
        reverse(a, 0, n - 1, n);
    }
}
