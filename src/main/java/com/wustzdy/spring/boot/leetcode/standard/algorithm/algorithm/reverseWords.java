package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

/**
 * 翻转单词顺序
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 */
public class reverseWords {
    public static void main(String[] args) {
        String string = "  hello world!  ";
        String reverseStr = reverseString1(string);
        System.out.println("reverseStr: " + reverseStr);
    }

    private static String reverseString(String string) {
        String[] splits = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String str = " ";
        for (int i = 0; i < splits.length; i++) {
            str = splits[i] + " " + str.trim();
        }
        return stringBuilder.append(str).toString().trim();
    }

    private static String reverseString1(String string) {
        String[] splits = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            stringBuilder.append(splits[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
