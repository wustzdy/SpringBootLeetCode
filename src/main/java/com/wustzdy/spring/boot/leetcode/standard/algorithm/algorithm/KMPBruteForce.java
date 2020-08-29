package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

/**
 * https://www.cnblogs.com/fuck1/p/6013543.html
 * 1.其基本思路是：从目标串s=“ s0s1…sn-1 ”的第一个字符开始和模式串t=“ t0t1…tm-1 ”中的第一个字符比较，若相等，则继续逐个比较后续字符，否则，从目标串s的第2个字符开始重新与模式串t的第一个字符进行比较，依次类推，若从目标串s的第i个字符开始，每个字符依次和模式串t中的对应字符相等，则匹配成功，该算法返回i;否则匹配失败，返回-1。
 * 2.举个栗子：
 */
public class KMPBruteForce {
    public static void main(String[] args) {
        String src = "cddcdc";
        String sub = "cdc";
        int index = bruteFore(src, sub);
        System.out.println("index: " + index);
    }

    private static int bruteFore(String src, String sub) {
        int i = 0, j = 0;
        int index = -1;
        while (i < src.length() && j < sub.length()) {
            if (src.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == sub.length()) {
            index = i - sub.length();
        }
        return index;
    }
}
