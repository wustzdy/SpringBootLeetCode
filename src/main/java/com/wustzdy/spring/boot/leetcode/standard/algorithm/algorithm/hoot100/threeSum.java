package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/?envType=study-plan-v2&envId=top-100-liked
//三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//你返回所有和为 0 且不重复的三元组。
/*
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/?envType=study-plan-v2&envId=top-100-liked
*/
public class threeSum {
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(array);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3)
            return ans;
        Arrays.sort(nums); // 排序
        //-4,-1,-1,0,1,2
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1])
                        L++; // 去重
                    while (L < R && nums[R] == nums[R - 1])
                        R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0)
                    L++;
                else if (sum > 0)
                    R--;
            }
        }
        return ans;
    }
}
