package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

//删除i到j的所有元素
public class DeleteElement {
    public static void main(String[] args) {
//        int arr[] = {4, 6, 2, 9, 10, 3};
        int arr[] = {2, 3, 4, 5, 6, 7};
        delete(arr, 3, 6);
    }

    static void delete(int arr[], int i, int j) {
        int k, data;
        data = j - i + 1;
        for (k = j + 1; k < arr.length; k++) {
            arr[k - data] = arr[k];
        }
        for (int m : arr) {
            System.out.print(m + ",");
        }
    }
}
