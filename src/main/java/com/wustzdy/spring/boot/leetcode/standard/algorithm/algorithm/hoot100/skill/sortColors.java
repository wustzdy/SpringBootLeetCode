package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.skill;
//颜色分类
//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

/**
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class sortColors {
    public static void main(String[] args) {
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        sortColors1(array);
    }
//    方法一：单指针
//    我们可以考虑对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 0 交换到数组的头部。
//    在第二次遍历中，我们将数组中所有的 1 交换到头部的 0 之后。此时，所有的 2 都出现在数组的尾部，
//    这样我们就完成了排序。
    public static void sortColors1(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    public static void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[n1++] = 1;
            }
            if (num < 1) {
                nums[n0++] = 0;
            }
        }
    }

//    22222222222 先全变成2
//    11111122222 再变成1
//    00011122222 再变成0

}
