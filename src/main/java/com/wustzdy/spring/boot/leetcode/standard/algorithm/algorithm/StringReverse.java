package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//字符串反转
public class StringReverse {
    public static void main(String[] args) {
        String str = "ABCDEF";

        //1. 利用 StringBuffer 或 StringBuilder 的 reverse 成员方法:
        String reverseStr = ReverseString1(str);
        System.out.println("reverseStr:" + reverseStr);

        //2. 利用 String 的 CharAt 方法取出字符串中的各个字符:
        String reverseStr2 = ReverseString2(str);
        System.out.println("reverseStr2:" + reverseStr2);

        //3,. 利用 String 的 toCharArray 方法先将字符串转化为 char 类型数组，然后将各个字符进行重新拼接:
        String reverseStr3 = ReverseString3(str);
        System.out.println("reverseStr3:" + reverseStr3);
    }

    private static String ReverseString3(String str) {
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = 0; i < chars.length; i++) {
            reverse = chars[i] + reverse;
        }
        return reverse;
    }

    private static String ReverseString2(String str) {
        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            rev = str.charAt(i) + rev;
        }
        return rev;
    }

    private static String ReverseString1(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }
}
