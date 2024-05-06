package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.dynamic;

//BM73 最长回文子串
//输入： "ababc"
//    返回值： 3
//    说明： 最长的回文子串为"aba"与"bab"，长度都为3
public class LongestPalindrome {
    public static void main(String[] args) {
        int max = getLongestPalindrome("ababc");
        System.out.println("max:" + max);
    }

    public static int getLongestPalindrome(String A) {
        if (A.length() <= 1) {
            return A.length();
        }
        int max = 1;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                String substring = A.substring(i, j + 1);
                if (substring.equals(new StringBuilder(substring).reverse().toString())) {
                    max = Math.max(max, substring.length());
                }
            }
        }
        return max;
    }
}
