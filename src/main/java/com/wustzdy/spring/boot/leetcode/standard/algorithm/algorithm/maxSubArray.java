package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
/*
最大子序和https://blog.csdn.net/zwzsdy/article/details/80029796
设sum[i]为以第i个元素结尾且和最大的连续子数组。假设对于元素i，所有以它前面的元素结尾的子数组的长度都已经求得，那么以第i个元素结尾且和最大的连续子数组实际上，要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素，即sum[i]
= max(sum[i-1] + a[i], a[i])。可以通过判断sum[i-1] + a[i]是否大于a[i]来做选择，而这实际上等价于判断sum[i-1]是否大于0。由于每次运算只需要前一次的结果，因此并不需要像普通的动态规划那样保留之前所有的计算结果，只需要保留上一次的即可，因此算法的时间和空间复杂度都很小
* */

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = subsequencesum_max(nums);
        System.out.println("max: " + max);
    }

    public static int maxSubArray(int[] arr) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            /*if (max < sum) {
                max = sum;
            }*/
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int subsequencesum_max(int[] arr) {
        int sum = 0, sum_max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > sum_max)
                sum_max = sum;
            else if (sum < 0)
                sum = 0;
        }
        return sum_max;
    }


}
