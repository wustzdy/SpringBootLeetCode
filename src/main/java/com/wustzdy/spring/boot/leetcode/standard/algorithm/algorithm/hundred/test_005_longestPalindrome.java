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

        boolean validPalindrome = validPalindrome("aba", 0, 2);
        System.out.println("validPalindrome: " + validPalindrome);

        String resultStr1 = longestPalindrome1("abcdedcb");
        System.out.println("resultStr1: " + resultStr1);
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


    private static String longestPalindrome1(String str) {
        int len = str.length();
        if (len < 2) {
            return str;
        }
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindrome(str, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return str.substring(begin, begin + maxLen);
    }

    /*
     *验证是否为回文字串
     */
    public static boolean validPalindrome(String str, int left, int right) {

        //aba
        char[] chars = str.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public String longestPalindrome11(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        String res = s.substring(0, 1);

        // 枚举所有长度大于等于 2 的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && valid(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
