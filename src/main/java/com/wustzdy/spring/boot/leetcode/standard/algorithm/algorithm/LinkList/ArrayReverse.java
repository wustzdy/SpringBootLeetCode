package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

//数据移动
//1，将一长度为n的数组的前端k(k<n)个元素逆序后移动到数组的后端，要求数组中数据元素不丢失，
public class ArrayReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int left = 0;
        int right = array.length - 1;
        int k = 3;
        int[] reverseArray = reverseArray(array, left, right, k);
        for (int element : reverseArray) {
            System.out.print(element + " ");
        }
    }

    private static int[] reverseArray(int[] array, int left, int right, int k) {
        int temp;
        for (int i = left, j = right; i < left + k && i < j; ++i, --j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    private static void moveToEnd(int a[], int n, int k) {
        reverseArray(a, 0, k - 1, k);
        reverseArray(a, 0, n - 1, k);
    }

    void moveP(int a[], int n, int p) {
        reverseArray(a, 0, p - 1, p);
        reverseArray(a, p, n - 1, n - p);
        reverseArray(a, 0, n - 1, n);
    }
}
