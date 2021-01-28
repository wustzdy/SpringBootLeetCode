package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

/**
 * 这种解法是暴力循环法，从题目可知：最长公共前缀的最长长度一定是字符串数组中长度最短哪个字符串。
 * 以第一个string为标准，依次判断是否是前缀，如果不是就减一，直到为前缀。
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String str = "flower,flow,flight";
        String prefix = longestCommonPrefix(str.split(","));
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
//        String str = "flower,flow,flight";
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];  //用于储存最长公共前缀，初始化为strs[0]
        for (String str : strs) {
            //当字符串str不以res为前缀时，就对res截断最后一个字符
            while (!str.startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
