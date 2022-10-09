package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hundred;

import java.util.Arrays;
import java.util.stream.Stream;
/*给定一个整数数组 nums和一个整数目标值 target，
        请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        你可以按任意顺序返回答案。*/
/*示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        示例 2：

        输入：nums = [3,2,4], target = 6
        输出：[1,2]
        示例 3：

        输入：nums = [3,3], target = 6
        输出：[0,1]*/
public class test_001_TwoSum {
    public static void main(String[] args) {
        int[] arg = new int[]{1, 3, 4, 5, 7};
        int target = 7;
        int[] result = result(arg, target);

        printf(result);
    }

    private static void printf(int[] result) {
        Stream.of(result).forEach(r -> System.out.println(Arrays.toString(r)));
    }

    public static int[] result(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
