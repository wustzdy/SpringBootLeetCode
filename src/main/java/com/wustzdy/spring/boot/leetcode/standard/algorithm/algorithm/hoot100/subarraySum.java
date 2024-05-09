package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100;

//和为K的子数组
// 1, 1, 1
// k=2
public class subarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int length = subarraySum(nums, 2);
        System.out.println("length:" + length);

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
