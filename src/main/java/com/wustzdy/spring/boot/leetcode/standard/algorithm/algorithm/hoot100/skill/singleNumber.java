package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.skill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//只出现一次的数字
//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

/**
 * 输入：nums = [2,2,1]
 * 输出：1
 * <p>
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 */
public class singleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int result = singleNumber2(nums);
        System.out.println("result:" + result);
//        singleNumber1(nums);

    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> map : frequencyMap.entrySet()) {
            if (map.getValue() == 1) {
                return map.getKey();
            }
        }
        return 0;
    }

    public static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map);//{1=2, 2=2, 4=1}

        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return 0;
    }
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
