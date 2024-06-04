package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.deap;

import java.util.HashMap;
import java.util.Map;

//统计素组中元素出现的个数
public class arrayCount {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 1, 4, 4};
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println("map:" + map);
    }
}
