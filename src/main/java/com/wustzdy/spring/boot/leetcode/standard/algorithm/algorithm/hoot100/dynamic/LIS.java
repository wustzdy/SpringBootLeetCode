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
//        int[] array = new int[]{10, 9, 2, 5, 3, 7, 101};
//        int[] array = new int[]{10, 1, 9, 5};
        int[] array = new int[]{1, 5, 3, 4,8};
        int lis = lengthOfLIS_new(array);
        System.out.println("lis:" + lis);

    }
    //new standard
    //https://www.bilibili.com/video/BV137411B7BN/?spm_id_from=333.337.search-card.all.click
    public static int lengthOfLIS11(int[] nums) {
        //len=7
        //数组下标：   0  1  2  3  4
        //原始数组num: 1, 5, 3, 4, 8
        //初始化dp[i]: 1  1  1  1  1
        //最终dp[i]:   1  2  2  3  4
        //上升子序列为   1 3 4 8
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
    public static int lengthOfLIS_new(int[] nums) {
        //len=7
        //数组下标：   0  1  2  3  4
        //原始数组num: 1, 5, 3, 4, 8
        //初始化dp[i]: 1  1  1  1  1
        //最终dp[i]:   1  2  2  3  4
        //上升子序列为   1 3 4 8 ,
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
        }
        //dp[i]=1  2  2  3  4,//求数组中最大值就可以
        res = Arrays.stream(dp).max().getAsInt();
        return res;
    }
    // 定义一个方法来找到数组中的最大元素
    public static int findMax(int[] arr) {
        // 初始化最大值为数组的第一个元素
        int max = arr[0];

        // 遍历数组，从第二个元素开始比较
        for (int i = 1; i < arr.length; i++) {
            // 如果当前元素大于max，更新max
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 返回最大值
        return max;
    }
}
