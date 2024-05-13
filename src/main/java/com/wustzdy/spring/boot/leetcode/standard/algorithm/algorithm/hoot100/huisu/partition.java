package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;
//分割回文串

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串,返回 s 所有可能的分割方案。
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class partition {
    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        System.out.print("result:" + result);
    }

    public static List<List<String>> lists = new ArrayList<>();
    public static Deque<String> deque = new LinkedList<>();

    public static List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    private static void backTracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }

    //判断是否是回文串
    private static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
