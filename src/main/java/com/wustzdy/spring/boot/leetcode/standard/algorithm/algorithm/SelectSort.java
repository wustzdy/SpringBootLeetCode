package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
//        int[] result = selectSort(arr);
//        for (int i : result) {
//            System.out.print(i + " ");
//        }
        selectSort(arr, arr.length);
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 找出最小值得元素下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;

    }

    public static void selectSort(int[] arr, int n) {
        // 2, 3, 6, 777, 8
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            int j;
            // 找出最小值的元素下标
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
            System.out.println(Arrays.toString(arr));
        }

    }

}
/*
性能分析：
        空间效率：仅使用常数个辅助单元，故而空间效率为O(1)。
        时间效率：从上述代码不难看出，简单选择排序过程中，元素移动操作次数很少，不会超过3(n-1)次，最好的情况是移动0次，此时对应的表已经有序；但元素间比较次数与序列的初始状态无关，
        始终是n(n-1)/2次，所以时间复杂度为O(n^2)。
        稳定性：在第i趟找到最小元素后，和第i个元素交换，可能会导致第i个元素与其他含有相同关键字元素的的相对饮位置发生改变。
        例如，表L={2，2，1}，经过一趟排序后，L={1，2，2}，最终排序序列也是L={1，2，2}，显然，2与2的相对次序已经发生了变化。因此，简单选择排序是一个不稳定的排序方法。*/
//0.如果遇到相等的值不进行交换，那这种排序方式是稳定的排序方式。


