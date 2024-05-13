package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * https://www.bilibili.com/video/BV1U84y1q7Ci/?spm_id_from=333.788&vd_source=5363405f0e14a0e8f06bcae41548f41e
 */
public class subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.print(result);
    }

    public static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    //    public static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public static List<Integer> path = new ArrayList<>();// 用来存放符合条件结果

    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private static void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length) { //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
