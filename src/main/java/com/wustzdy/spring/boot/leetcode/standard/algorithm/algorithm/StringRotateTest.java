package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//剑指 Offer 58 - II. 左旋转字符串
/*字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
        示例 1：

        输入: s = "abcdefg", k = 2
        输出: "cdefgab"
        示例 2：

        输入: s = "lrloseumgh", k = 6
        输出: "umghlrlose"

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof*/
public class StringRotateTest {
    public static void main(String[] args) {
        String str = "lrloseumgh";
        int k = 6;
//        String resultStr = LeftRotate(str, k);
//        System.out.println(resultStr);

        System.out.print(reverseLeftWords(str, k));
    }

    private static String LeftRotate(String str, int k) {
        String substring = str.substring(0, k);
        String substring1 = str.substring(substring.length(), str.length() - 1);
        String substring2 = str.substring(str.length() - 1);

        return substring1 + substring2 + substring;
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
