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
        int[] array=new int[]{2,0,2,1,1,0};
        sortColors(array);
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
