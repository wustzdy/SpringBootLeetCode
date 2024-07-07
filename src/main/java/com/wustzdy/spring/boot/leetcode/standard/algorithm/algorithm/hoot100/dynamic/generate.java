package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//杨辉三角
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
/*
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
*/

public class generate {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate1(5);
        System.out.print(generate);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;

    }

    public static List<List<Integer>> generate1(int numRows) {
        // 初始化动态规划数组
        Integer[][] dp = new Integer[numRows][];
        // 遍历每一行
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 每一行的第一个和最后一个元素总是 1
            dp[i][0] = dp[i][i] = 1;
            // 计算中间元素
            for (int j = 1; j < i; j++) {
                // 中间元素等于上一行的相邻两个元素之和
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        // 将动态规划数组转换为结果列表
        List<List<Integer>> result = new ArrayList<>();
        for (Integer[] row : dp) {
            result.add(Arrays.asList(row));
        }
        // 返回结果列表
        return result;
    }
}
