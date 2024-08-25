package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.skill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//寻找重复数
/*
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
*/
/*
输入：nums = [1,3,4,2,2]
输出：2

输入：nums = [3,1,3,4,2]
输出：3

方法一：哈希表

利用数据结构特点，容易想到使用哈希表（Set）记录数组的各个数字，当查找到重复数字则直接返回。
算法流程：
    初始化： 新建 HashSet ，记为 hmaphmaphmap 。
    遍历数组 numsnumsnums 中的每个数字 numnumnum ：
        当 numnumnum 在 hmaphmaphmap 中，说明重复，直接返回 numnumnum 。
        将 numnumnum 添加至 hmaphmaphmap 中。
    返回 −1。本题中一定有重复数字，因此这里返回多少都可以。
*/

public class findDuplicate {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 2};
        int result = findDuplicate(array);
        System.out.println("result:" + result);

    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> hmap = new HashSet<>();// 无序不重复
        for (int num : nums) {
            if (hmap.contains(num)) {
                return num;
            } else {
                hmap.add(num);
            }
        }
        return -1;
    }

    public static int findDuplicate1(int[] nums) {
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
            if (value != 1) {
                return num;
            }
        }
        return -1;
    }
}
