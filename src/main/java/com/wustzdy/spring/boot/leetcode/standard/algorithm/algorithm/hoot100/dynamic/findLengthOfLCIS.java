package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

//674. 最长连续递增序列
// 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

import java.util.Arrays;

/**
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * <p>
 * 如果 nums[i] > nums[i - 1]，那么以 i 为结尾的连续递增的子序列长度 一定等于 以i - 1为结尾的连续递增的子序列长度 + 1 。
 * 即：dp[i] = dp[i - 1] + 1;
 */
public class findLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        int result = findLengthOfLCIS(nums);
        System.out.println("result:" + result);

    }
    //https://www.bilibili.com/video/BV1bD4y1778v/?spm_id_from=333.788&vd_source=5363405f0e14a0e8f06bcae41548f41e
    public static int findLengthOfLCIS(int[] nums) {
        //n=5
        //0 1 2 3 4
        //1,3,5,4,7
        //1,2,3,1,2
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
        }
        res = Arrays.stream(dp).max().getAsInt();
        return res;
    }
    //standard
    public static int findLengthOfLCIS1(int[] nums) {
        //n=5
        //下标：    0 1 2 3 4
        //nums[i]: 1,3,5,4,7
        //dp[i]:   1,2,3,1,2
        //求连续最长连续递增序列是 [1,3,5]长度，也就是求dp[i]中最大的数字
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        res = Arrays.stream(dp).max().getAsInt();//也就是求dp[i]中最大的数字
        return res;
    }
}
