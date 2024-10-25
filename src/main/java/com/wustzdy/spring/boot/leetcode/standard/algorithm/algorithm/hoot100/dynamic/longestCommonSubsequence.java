package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

// 7,1143.最长公共子序列-求长度
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//输入：输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。


// 5，BM65 最长公共子序列-不要求连续(二)-求字符串
//给定两个字符串str1和str2，输出两个字符串的最长公共子序列。
//如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
// 输入："abcde","ace"
// 返回值："ace"
public class longestCommonSubsequence {
    public static void main(String[] args) {

        String str1 = "abcde";
        String str2 = "ace";
        int result_length = longestCommonSubsequence_length(str1, str2);
        System.out.println("result_length:" + result_length);

        String result_str = longestCommonSubsequence_str(str1, str2);
        System.out.println("result_str:" + result_str);

    }

    //https://programmercarl.com/1143.%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
    public static int longestCommonSubsequence_length(String text1, String text2) {
        /**     00   a  c  e
         *      0    0  0  0
         * a    0    1  1  1
         * b    0    1  1  1
         * c    0    1  2  2
         * d    0    1  2  2
         * e    0    1  2  3
         *
         * 00 01 02 03
         * 10 11 12 13
         * 20 21 22 23
         * 30 31 32 33
         *
         * */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1; i < text1.length() +1; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j < text2.length() + 1; j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static String longestCommonSubsequence_str(String s1, String s2) {
        //s1:abcde
        //s2:ace
        // 字符串1的长度
        int sLen1 = s1.length();
        // 字符串2的长度
        int sLen2 = s2.length();
        // dp数组，初始化高度和宽度分别为两个字符串长度+1
        // 目的是方便初始化，如果高度和宽度分别是两个字符串的长度，初始化会比较麻烦
        // s1[0,i)和s2[0,j)所构成的最长子序列是dp[i][j]
        String[][] dp = new String[sLen1 + 1][sLen2 + 1];
        // dp数组初始化
        for (int i = 0; i <= sLen1; i++) {
            dp[i][0] = "";
        }
        for (int j = 0; j <= sLen2; j++) {
            dp[0][j] = "";
        }
        // 遍历每一种情况
        for (int i = 1; i <= sLen1; i++) {
            for (int j = 1; j <= sLen2; j++) {
                // 因为长度和宽度都是字符串长度+1，所以这里取字符的时候需要减1，保证不越界
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 因为要加入的两个字符一样，所以直接取两个字符加入前的最长公共子序列然后加上这个相等的字符
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    // 取s1不加入当前字符和s2不加入当前字符的情况中的最长的那个子序列
                    if (dp[i - 1][j].length() >= dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return "".equals(dp[sLen1][sLen2]) ? "-1" : dp[sLen1][sLen2];
    }

    public static int longestCommonSubsequence_length1(String s1, String s2) {
        //s1:abcde
        //s2:ace
        // 字符串1的长度
        int sLen1 = s1.length();
        // 字符串2的长度
        int sLen2 = s2.length();
        // dp数组，初始化高度和宽度分别为两个字符串长度+1
        // 目的是方便初始化，如果高度和宽度分别是两个字符串的长度，初始化会比较麻烦
        // s1[0,i)和s2[0,j)所构成的最长子序列是dp[i][j]
        String[][] dp = new String[sLen1 + 1][sLen2 + 1];
        // dp数组初始化
        for (int i = 0; i <= sLen1; i++) {
            dp[i][0] = "";
        }
        for (int j = 0; j <= sLen2; j++) {
            dp[0][j] = "";
        }
        // 遍历每一种情况
        for (int i = 1; i <= sLen1; i++) {
            for (int j = 1; j <= sLen2; j++) {
                // 因为长度和宽度都是字符串长度+1，所以这里取字符的时候需要减1，保证不越界
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 因为要加入的两个字符一样，所以直接取两个字符加入前的最长公共子序列然后加上这个相等的字符
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    // 取s1不加入当前字符和s2不加入当前字符的情况中的最长的那个子序列
                    if (dp[i - 1][j].length() >= dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        String string = "".equals(dp[sLen1][sLen2]) ? "-1" : dp[sLen1][sLen2];
        return string.length();
    }
}
