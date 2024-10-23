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
            int len1 = expandAroundCenter(s, i, i);
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
            //bab-偶数
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
            //baab-奇数
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
        return s.substring(ll, rr + 1);
    }

    public static String longestPalindrome111(String s) {
        int res_len = 0;
        int res_start = 0;
        for (int i = 0; i < s.length(); i++) {
            //bab-偶数
            int L = i, R = i;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                if (R - L + 1 > res_len) {
                    res_len = R - L + 1;
                    res_start = L;
                }
                --L;
                ++R;
            }
            //baab-奇数
            L = i;
            R = i + 1;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                if (R - L + 1 > res_len) {
                    res_len = R - L + 1;
                    res_start = L;
                }
                --L;
                ++R;
            }
        }
        return s.substring(res_start, res_len);
    }

    public static String longestPalindrome1111(String s) {
        if (s.length() < 1)
            return "";
        String longestPalindrome = "";//存放最长回文字串
        int max = 0;
        int temp = 0;//temp是用来保存当前子串的长度的，max存放的就是最大长度
        int left = 0, right = 0;
        //第一种情况回文字串个数是奇数，那么他的中心就只有一个
        for (int i = 0; i < s.length(); i++) {
            left = right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
//假如字串的left==right，那么字串就需要进行扩展。
            //经过检验left==0时再进行--，right==0在进行++，然后用right-left-1这样得到的长度为1
//不影响。
            {
                left--;
                right++;//这样操作过后，s.charAt(left)！=s.charAt(left)可能会出现
//所以temp的计算公式是temp=right-left-1;需要将left和right排除在外
            }
            temp = right - left - 1;
            if (temp > max)//假如temp>max时，把max和最长回文字符串更新
            {
                max = temp;
                longestPalindrome = s.substring(left + 1, right);
            }
        }
        //第二种情况是回文字串个数是偶数时，那么此时的中心就有两个
        for (int i = 0; i < s.length() - 1; i++) //这种情况需要注意的是当i=length-1时无法向右扩张
//所以不要
        {
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            temp = right - left - 1;
            if (temp > max)//假如temp>max时，把max和最长回文字符串更新
            {
                max = temp;
                longestPalindrome = s.substring(left + 1, right);
            }
        }
        return longestPalindrome;
    }

}
