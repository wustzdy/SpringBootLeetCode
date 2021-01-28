package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//58. 最后一个单词的长度
/*给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

        如果不存在最后一个单词，请返回 0 。

        说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
        示例:

        输入: "Hello World"
        输出: 5*/
public class lengthOfLastWord {
    public static void main(String[] args) {
        String str = "Hello word";
        int length = lengthOfLastWordFunction(str);
        System.out.println("length: " + length);
    }

    private static int lengthOfLastWordFunction(String str) {
        if (str == "" || str.length() == 0 || str == null) {
            return 0;
        }
        String[] split = str.split(" ");
        if (split.length > 0) {
            return split[split.length - 1].length();
        }
        return 0;
    }
}
