package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
//        int[] nums = new int[]{3,2,3};
        int result = majorityElement3(nums);
        System.out.println("result:" + result);

    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map);

        for (int num : map.keySet()) {
            int value = map.get(num);
            if (value > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    public static int majorityElement3(int[] nums) {
        //2, 2, 1, 1, 1, 2, 2
        Arrays.sort(nums);//1,1,1,2,2,2,2
        for (int i : nums) {
            System.out.print(i+",");
        }
        return nums[nums.length / 2]; // 7/2=3 下标为3
    }
}
