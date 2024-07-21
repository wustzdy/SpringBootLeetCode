package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

//暴力解法
//直接判断每一个子串是不是回文子串，然后取其中最长的值返回
public class Palindrome {
    public static void main(String[] args) {
        int max = countSubstrings("aaa");
        System.out.println("max:" + max);
    }
    public static int getLongestPalindrome(String A) {
        int n=A.length();
        int maxLen = 0;
        //暴力解法
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String now = A.substring(i, j);
                if (isPalindrome(now) && now.length() > maxLen) {
                    maxLen = now.length();
                }
            }
        }
        return maxLen;
    }

    //判断子串是不是回文子串
    public static boolean isPalindrome(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1))
                return false;
        }
        return true;
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}
