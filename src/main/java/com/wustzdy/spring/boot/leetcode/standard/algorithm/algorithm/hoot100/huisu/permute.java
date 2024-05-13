package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;

import java.util.ArrayList;
import java.util.List;

public class permute {

    public static void main(String[] args) {
//        int[] nums=new int[]{1,2};
//        List<List<Integer>> permute = permute(nums);
//        System.out.print("permute:"+permute);




    }
    public static void permute1(int[] nums){
        //暴力
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(i+""+j);
            }
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(list, temp, nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        // 终止条件
        if (temp.size() == nums.length) {
            // 存放结果
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 找到一个不在 temp 里的数字
            if (temp.contains(nums[i])){
                continue;
            }
            // 放进去一个元素
            temp.add(nums[i]);
            // 执行递归公式
            backtrack(list, temp, nums);
            // 撤回这个元素
            temp.remove(temp.size() - 1);
        }
    }


}
