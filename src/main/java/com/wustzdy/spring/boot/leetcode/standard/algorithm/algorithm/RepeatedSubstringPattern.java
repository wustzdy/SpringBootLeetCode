package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

/**
 * 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 输入: "aba"
 * 输出: False
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String str = "abab";
        boolean b = repeatedSubstringPattern(str);
        System.out.println("b: " + b);
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0 && check(s, i, len / i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(String str, int i, int j) {
        String string = str.substring(0, i);
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < j; index++) {
            stringBuilder.append(string);
        }
        return str.equals(stringBuilder.toString());
    }
}
