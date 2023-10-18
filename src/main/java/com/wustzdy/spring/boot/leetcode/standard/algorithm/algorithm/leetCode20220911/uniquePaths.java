package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//不同路径
public class uniquePaths {
    public static void main(String[] args) {
        int total = uniquePathsFun(7, 3);
        System.out.println("total:" + total);
    }

    private static int uniquePathsFun(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
