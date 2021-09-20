package com.wustzdy.spring.boot.leetcode.standard.algorithm.sort;

import java.util.Arrays;
//【排序】折半插入排序
public class HalfSearchSort {
    public void sort(int[] array) {
        int temp;

        for (int i = 1; i < array.length; i++) {
            int low = 0;
            int hight = i - 1;
            temp = array[i];

            while (hight >= low) {
                int mid = (low + hight) / 2;
                if (array[mid] > temp) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i - 1; j > hight; j--) {
                array[j + 1] = array[j];
            }

            array[hight + 1] = temp;

        }

    }

    public static void main(String[] args) {
        HalfSearchSort sort = new HalfSearchSort();
        int a[] = {8, 5, 4, 3, 2, 1, 6, 7};

        System.out.println("Before: " + Arrays.toString(a));
        //System.out.println(5/2);
        sort.sort(a);
        System.out.println("After: " + Arrays.toString(a));
    }
}

/*
https://blog.csdn.net/Adelaide_Guo/article/details/82149098?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-7.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-7.control
复杂度分析和稳定性
        复杂度

和直接插入排序相比较，折半插入排序仅仅是减少了比较的次数，而移动总次数并没有发生改变。这个比较次数大概是，移动次数没有改变，所以其复杂度和直接插入排序是一样的。

稳定性
根据代码分析可以知道，当待插入数与mid位置的值相等时，接下来相当于进入了有序序列的右半区，mid+1到high，之后经过多次折半查找，该元素所找到的合适位置就是前一个与之相等元素的后一位，所以说两者相对位置没有发生变化，这般插入排序是稳定的。

总结
折半插入排序其实是在直接插入排序的基础上，结合了二分查找法的思想，顺序的二分查找替代了直接插入排序中遍历查找的过程，从而更快的能够确定待插入元素的位置，但是由于移动次数并没有发生改变，所以两者的时间复杂度相同。折半插入排序是稳定的，其时间复杂度为。
 */
