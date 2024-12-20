package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.skill;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//多数元素
// 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
/*
输入：nums = [3,2,3]
输出：3

输入：nums = [2,2,1,1,1,2,2]
输出：2
*/
public class majorityElement {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int[] nums = new int[]{3,2,3};
        int result = majorityElement(nums);
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
        System.out.println(map);//{{3=2,2=1}}

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
