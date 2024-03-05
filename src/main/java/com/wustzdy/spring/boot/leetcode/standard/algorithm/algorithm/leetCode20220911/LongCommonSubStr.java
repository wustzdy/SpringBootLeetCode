package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//最长公共字串-字符串
//给定两个字符串str1和str2,输出两个字符串的最长公共子串
//题目保证str1和str2的最长公共子串存在且唯一。
/*
输入："1AB2345CD","12345EF"
返回值： "2345"
*/

//最长公共字串-长度
//给定两个字符串str1和str2,输出两个字符串的最长公共子串
//题目保证str1和str2的最长公共子串存在且唯一。
/*
输入："1AB2345CD","12345EF"
返回值： 4
*/
public class LongCommonSubStr {
    private static final String EMPTY = "";

    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "2345";
        String result = LCS(str1, str2);
        System.out.println("result:" + result);
    }

    public static String LCS(String str1, String str2) {
        int sLen1 = str1.length();
        int sLen2 = str2.length();
        // dp[i][j]是包含字符str1[i-1]和字符str2[j-1]的最长子串
        String[][] dp = new String[sLen1 + 1][sLen2 + 1];
        for (int i = 0; i <= sLen1; i++) {
            dp[i][0] = EMPTY;
        }
        for (int j = 0; j <= sLen2; j++) {
            dp[0][j] = EMPTY;
        }
        // 保存最后的结果，在刷dp的时候更新ans
        String ans = EMPTY;
        for (int i = 1; i <= sLen1; i++) {
            for (int j = 1; j <= sLen2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                    // 找到更大的结果了
                    if (dp[i][j].length() > ans.length()) {
                        ans = dp[i][j];
                    }
                } else {
                    dp[i][j] = EMPTY;
                }
            }
        }
        return ans;
    }
}
