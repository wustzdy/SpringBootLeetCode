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
        int array[] = {1, 2, 3, 4, 5};
        int p = 3;
        //1,
//        reverse(array, 0, array.length - 1, p);////逆置前P

        //2,
//        moveToEnd(array, array.length, p);

        //3,
//        moveP(array, array.length, p);
        //3,
//        moveP1(array, 3, array.length);
        //3,
        movep2(array, 3);
       /* for (int i : array) {
            System.out.print(i + ",");
        }*/

    }

    private static void movep2(int[] array, int p) {
        int[] tempArray = new int[array.length];
        for (int i = p, j = 0; i < array.length && j < array.length - p; i++, j++) {
            tempArray[j] = array[i];
        }
        for (int i = 0, j = p - 1; i < p && j < array.length; i++, j++) {
            tempArray[j] = array[i];
        }
        for (int i : tempArray) {
            System.out.print(i + " ");
        }
    }

    private static void moveP1(int[] array, int p, int n) {
        Reverse(0, p - 1, array);////逆置前P个
        Reverse(p, n - 1, array);//逆置后n-p个
        Reverse(0, n - 1, array);//逆置整个数组
    }

    /*参数说明：
        a[]:要改变的数组
       left:左边起点
      right:右边终点
          k:要移动的元素个数*/
    private static void reverse(int a[], int left, int right, int k) {
        int temp;
        for (int i = left, j = right; i < left + k && i < j; ++i, --j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    //第二题
    private static void moveToEnd(int a[], int n, int k) {
        reverse(a, 0, k - 1, k); //reverse函数为第一题中的
        reverse(a, 0, n - 1, k);
    }


    //第三题
    private static void moveP(int a[], int n, int p) {
        reverse(a, 0, p - 1, p);
        reverse(a, p, n - 1, n - p);
        reverse(a, 0, n - 1, n);
    }

    private static void Reverse(int left, int right, int A[]) {
        if (left >= right || right >= A.length)
            return;
        int mid = (left + right) / 2;
        for (int i = 0; i <= mid - left; i++) {
            int temp = A[left + i];
            A[left + i] = A[right - i];
            A[right - i] = temp;
        }
    }
}
