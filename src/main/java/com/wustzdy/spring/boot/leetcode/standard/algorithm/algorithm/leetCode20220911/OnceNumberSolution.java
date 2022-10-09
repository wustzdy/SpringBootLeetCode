package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//只出现一次的数
//        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
/*示例 1:
        输入: [2,2,1]
        输出: 1

        示例 2:
        输入: [4,1,2,1,2]
        输出: 4*/
/*
解析
        用 HashMap 的这个方法是很容易实现的，题目要求不是让我们求次数嘛，那我们直接遍历数组将每个数字和其出现的次数存到 哈希表里 就可以了，然后我们再从哈希表里找出出现一次的那个数返回即可。*/
/*key       4,1,2
value(次数)1,2,2*/
public class OnceNumberSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int res = singleNumber3(nums);
        System.out.println("res: " + res);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);//若已经存在获取次数并加1.
            } else {
                map.put(nums[i], 1);//若该元素不存在则存入表中，并计数为1
            }
        }
        System.out.println("map: " + map.toString());
        for (Integer a : map.keySet()) {
            if (map.get(a) == 1) {
                return a;
            }
        }
        return -1;
    }

    public static int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer a : map.keySet()) {
            if (map.get(a) == 1) {
                return a;
            }
        }
        return -1;
    }

    public static int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashSet<Integer> set = new HashSet<>();
        //循环遍历
        for (int x : nums) {
            //已经存在，则去除
            if (set.contains(x)) {
                set.remove(x);
            }
            //否则存入
            else {
                set.add(x);
            }
        }
        //返回仅剩的一个元素
        return set.iterator().next();
    }

    //    4, 1, 2, 1, 2
    public static int singleNumber3(int[] nums) {
        int num = 0;
        //异或
        for (int x : nums) {
            num ^= x;
        }
        return num;
    }
}
