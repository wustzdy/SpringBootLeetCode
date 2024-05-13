package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.array;

import java.util.HashMap;

//LeetCode 题解 | 1. 两数之和
public class twoSumTotal {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1};
        int[] albel = twoSum(array, 2);
        for (int e : albel) {
            System.out.println(e);
        }
    }

    private static int[] twoSum1(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    //standard
    public static int[] twoSum(int[] nums, int target) {
        //            6 3 8 2 1
        // map  key   6 3 8
        //      value 0 1 2

        HashMap<Integer, Integer> map = new HashMap<>();
        //一次遍历
        for (int i = 0; i < nums.length; ++i) {
            //存在时，我们用数组得值为 key，索引为 value
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //存入值
            map.put(nums[i], i);
        }
        //返回
        return new int[0];
    }

}
