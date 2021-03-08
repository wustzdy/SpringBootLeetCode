package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//1684. 统计一致字符串的数目
/*给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
        请你返回 words 数组中 一致字符串 的数目。
        示例 1：

        输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
        输出：2
        解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
        示例 2：

        输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
        输出：7
        解释：所有字符串都是一致的。
        示例 3：

        输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
        输出：4
        解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings*/
public class StringCount {
    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        int count = CountConsistentStrings(allowed, words);
        System.out.println("count: " + count);
    }

    public static int CountConsistentStrings(String allowed, String[] words) {
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            boolean bo = true;
            String a = words[i];
            for (int j = 0; j < words[i].length(); j++) {
                if (allowed.indexOf(a) == -1) {
                    bo = false;
                }
            }
            if (bo == true)
                num++;
        }
        return num;
    }

}
