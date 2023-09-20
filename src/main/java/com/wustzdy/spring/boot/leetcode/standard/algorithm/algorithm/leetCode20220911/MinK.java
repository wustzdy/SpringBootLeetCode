package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//2,JZ40 最小的K个数

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 描述
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 * 数据范围：0≤k,n≤100000≤k,n≤10000，数组中每个数的大小0≤val≤10000≤val≤1000
 * 要求：空间复杂度 O(n)O(n) ，时间复杂度 O(nlogk)O(nlogk)
 * <p>
 * 示例1
 * 输入：
 * <p>
 * [4,5,1,6,2,7,3,8],4
 * <p>
 * 返回值：
 * <p>
 * [1,2,3,4]
 * <p>
 * 说明：
 * <p>
 * 返回最小的4个数即可，返回[1,3,2,4]也可以
 * <p>
 * 示例2
 * 输入：
 * <p>
 * [1],0
 * <p>
 * 返回值：
 * <p>
 * []
 * <p>
 * 示例3
 * 输入：
 * <p>
 * [0,1,2,1,2],3
 * <p>
 * 返回值：
 * <p>
 * [0,1,1]
 */
public class MinK {
    public static void main(String[] args) {
        int[] arrays = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = mixKElement(arrays, 3);
        System.out.println("result:" + result);
    }

    private static ArrayList<Integer> mixKElement(int[] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(input[i]);
        return res;
    }
}
