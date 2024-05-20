package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

import java.util.Arrays;

//完全平方数
/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4

输入：n = 13
输出：2
解释：13 = 4 + 9
*/
public class numSquares {
    public static void main(String[] args) {
        int result = numSquares2(5);
        System.out.print("result:" + result);
    }

    public static int numSquares1(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];

    }

    public static int numSquares(int n) {
        int x = (int) Math.floor(Math.sqrt(n));
        int[][] dp = new int[x + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= i * i)
                    dp[i][j] = Math.min(dp[i][j - i * i] + 1, dp[i][j]);

            }
        }
        return dp[x][n];
    }

    public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }

    public static int numSquares3(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}