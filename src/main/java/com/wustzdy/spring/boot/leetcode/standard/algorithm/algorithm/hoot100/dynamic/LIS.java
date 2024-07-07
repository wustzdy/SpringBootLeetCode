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
        int lis = lengthOfLIS2s(array);
        System.out.println("lis:" + lis);

    }

    public static int LIS(int[] arr) {
        //6, 3, 1, 5, 2, 3, 7
        //特殊情况考虑
        int len = arr.length;
        if (arr == null || len == 0) {
            return 0;
        }

        //dp[i]:表示arr以i为结尾的最长上升子序列的个数
        //很明显dp初始的值是1，在计算过程中顺便记录最大值的情况
        //j的遍历是：i之前的所有以j为结尾的最长上升子序列的个数 也就是当前的数值arr[i] > arr[j],
        // 那么是从arr[j]过来呢还是直接从arr[i]开始呢
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public int lengthOfLIS(int[] arr) {
        int len = arr.length;
        if (arr == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 1;
        for (int i = 1; i < len; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //https://leetcode.cn/problems/longest-increasing-subsequence/solutions/147667/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/?envType=study-plan-v2&envId=top-100-liked
    public static int lengthOfLIS2s(int[] arr) {
        //10, 9, 2, 5, 3, 7, 101
        // 1  1  1  1  1  1   1
        int len = arr.length;
        if (arr == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
