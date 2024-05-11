package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//全排列

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * https://www.bilibili.com/video/BV19v4y1S79W/?spm_id_from=333.788&vd_source=5363405f0e14a0e8f06bcae41548f41e
 */
public class permute1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.print(result);

    }

    public static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    public static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private static void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
