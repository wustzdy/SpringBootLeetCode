package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.print(result);
    }
    public static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    public static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private static void backtracking(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
