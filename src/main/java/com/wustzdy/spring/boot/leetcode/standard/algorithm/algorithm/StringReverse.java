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

        /**
         * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
         *
         * 示例 1:
         *
         * 输入: "Let's take LeetCode contest"
         * 输出: "s'teL ekat edoCteeL tsetnoc" 
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。**/
        String reverseStr4 = ReverseString4(str);
        System.out.println("reverseStr4:" + reverseStr4);

        String reverseStr5 = ReverseString5(str);
        System.out.println("reverseStr5:" + reverseStr5);
    }

    private static String ReverseString5(String str) {
        str = "Let's take LeetCode contest";
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split(" ");
        String reverse = "";
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(str.charAt(i) + reverse + " ");
        }
        return stringBuilder.toString();
    }

    private static String ReverseString4(String str) {
        str = "Let's take LeetCode contest";
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split(" ");
        for (String word : strings) {
            stringBuilder.append(new StringBuilder(word).reverse().toString() + " ");

        }
        return stringBuilder.toString().trim();
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
