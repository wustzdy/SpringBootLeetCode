package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

//判断是否为回文串
public class IsPalindromicString {
    public static void main(String[] args) {
        String str = "bab";
        boolean result = isPalindromicString(str);
        System.out.println("result:" + result);
    }

    public static boolean isPalindromicString(String str) {
        int n = str.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
