package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

//BM73 最长回文子串
//输入： "ababc"
//    返回值： aba
//    说明： 最长的回文子串为"aba"与"bab"，长度都为3
public class LongestPalindrome {
    public static void main(String[] args) {
        String max = longestPalindrome("ababc");
        System.out.println("max:" + max);

        String max1 = longestPalindrome1("ababc");
        System.out.println("max1:" + max1);


    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//一个字符作为中心点
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {//如果是回文，则扩大范围
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static String longestPalindrome1(String s) {
        int res = 1;
        int ll = 0;
        int rr = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > res) {
                    res = len;
                    ll = l;
                    rr = r;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > res) {
                    res = len;
                    ll = l;
                    rr = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(ll,rr+1);
    }

}
