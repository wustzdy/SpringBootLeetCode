package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

import java.util.Arrays;

//最长上升子序列
//输入：[6,3,1,5,2,3,7]
//        返回值：4
//        说明：
//        该数组最长上升子序列为 [1,2,3,7] ，长度为4
public class LIS {
    public static void main(String[] args) {
//        int[] array = new int[]{6, 3, 1, 5, 2, 3, 7};
        int[] array = new int[]{10, 9, 2, 5, 3, 7, 101};
        int lis = lengthOfLIS11(array);
        System.out.println("lis:" + lis);

    }
    //new standard
    //https://www.bilibili.com/video/BV137411B7BN/?spm_id_from=333.337.search-card.all.click
    public static int lengthOfLIS11(int[] nums) {
        // 6  3  1  5  2  3 7
        // 1  1  1  1  1  1 1
        //上升子序列为 1 2 3 7 ,
        //故长度为4
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
