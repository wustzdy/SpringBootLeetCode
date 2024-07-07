package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

//BM68 矩阵的最小路径和
//输入：
//        [[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
//        返回值：
//        12
public class minPathSum {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}};
        int[][] matrix = {{1, 3, 1}, {1,5,1}, {4,2,1}};
        int sum = minPathSum1(matrix);
        System.out.println("sum:" + sum);
    }

    public static int minPathSum(int[][] matrix) {
        // write code here
        // 行数
        int m = matrix.length;
        // 列数
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    matrix[i][j] += matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i - 1][j];
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[m - 1][n - 1];
    }

    //https://www.bilibili.com/video/BV1yN411d7Pr/
//    给定数组   dp数组
//         *  1 3 1     1 4 5
//         *  1 5 1     2 7 6
//         *  4 2 1     6 8 7
    public static int minPathSum1(int[][] matrix) {
        // write code here
        int n = matrix.length; //matrix的行
        int m = matrix[0].length;//matrix的列
        int[][] dp = new int[n][m];//dp[i][j]代表在第i行第j列最小的路径和为多少
        dp[0][0] = matrix[0][0];//初始化dp[0][0]为matrix[0][0]
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];//初始化dp[i][0]
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];//初始化dp[0][i]
        }
        for (int i = 1; i < n;i++) {
            for (int j = 1; j < m;j++) {
                //dp[i][j] 就应该等于在dp[i - 1][j]、dp[i][j - 1]选一个最小的在和matrix[i][j]加和
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[n - 1][m - 1];//最终的结果为dp[n-1][m-1]即二维表的最右下角
    }
}
