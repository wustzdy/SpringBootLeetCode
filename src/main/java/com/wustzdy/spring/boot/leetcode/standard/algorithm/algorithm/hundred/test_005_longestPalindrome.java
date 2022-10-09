package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hundred;

/*最长回文子串
回文串（palindromic string）是指这个字符串无论从左读还是从右读，所读的顺序是一样的；简而言之，回文串是左右对称的。所谓最长回文子串问题，是指对于一个给定的母串
abcdedcb
从所有的为回文串的子串a, ded, cdedc, bcdecdb中；找出最长的那一个bcdecdb。
但是该如何判断子串是否回文然后找出最长者呢？
*/
public class test_005_longestPalindrome {
    public static void main(String[] args) {
        String resultStr = longestPalindrome("abcdedcb");
        System.out.println("resultStr: " + resultStr);

    }

    public static String longestPalindrome(String s) {
        int begin = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int left = maxStringLength(s, i, i);
            int right = maxStringLength(s, i, i + 1);
            int curMaxLen = Math.max(left, right);
            if (maxLen < curMaxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }

        }
        return s.substring(begin, begin + maxLen);
    }

    public static int maxStringLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
