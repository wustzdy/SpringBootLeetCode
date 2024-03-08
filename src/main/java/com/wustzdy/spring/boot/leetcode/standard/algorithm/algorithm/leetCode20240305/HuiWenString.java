package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20240305;

//BM88 判断是否为回文字符串
// 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
//         字符串回文指该字符串正序与其逆序逐字符一致。
//输入：
//        "absba"
//        返回值：
//        true

//输入：
//        "yamatomaya"
//        返回值：
//        false

public class HuiWenString {
    public static void main(String[] args) {
        System.out.println("result:" + judge("absba"));
        System.out.println("result:" + judgeChat("absba"));
        System.out.println("result:" + judgeChatWhile("absba"));
    }

    public static Boolean judge(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String reverse = stringBuilder.reverse().toString();
        return reverse.equals(str);
    }

    public static Boolean judgeChat(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean judgeChatWhile(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
