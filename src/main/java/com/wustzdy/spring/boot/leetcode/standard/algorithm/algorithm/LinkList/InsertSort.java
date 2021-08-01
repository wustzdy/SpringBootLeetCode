package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 10};
        int x = 5;
        int length = arr.length;
        sort(arr, x, length);
    }

    static void sort(int arr[], int x, int length) {
        int low = 0, high = length - 1, mid = 0;                  //low和high分别指向线性表的上界和下界
        while (low <= high) {
            mid = (low + high) / 2;                       //中间位置
            if (arr[mid] == x)                               //找到退出循环
                break;
            else if (arr[mid] < x)                        //在右边查找
                low = mid + 1;
            else                                         //在左边查找
                high = mid - 1;
        }
        System.out.println("---mid:" + mid);
        if (arr[mid] == x && mid != length - 1)                  //找到且不是最后一个元素与其后面元素交换位置
        {
            int t;
            t = arr[mid];
            arr[mid] = arr[mid + 1];
            arr[mid + 1] = t;
        }
        if (low > high)                                    //没有找到，插入元素
        {
            int i;
            for (i = length - 2; i > high; i--)                   //元素后移
            {
                arr[i + 1] = arr[i];
            }
            //表长增加1
            arr[i + 1] = x;                             //插入元素
        }

//        arr.[length - 1]=10;
        for (int element : arr) {
            System.out.print(element + ",");
        }
    }

    public void insert(int[] a, int lower, int upper, int x) {
        for (int i = upper; i >= lower; i--) {
            if (a[i] > x) {
                a[i + 1] = a[i];
            } else {
                a[i + 1] = x;
                return;
            }
        }
    }
}
