package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20230723;

import java.util.HashSet;
import java.util.Set;

//3. 无重复字符的最长子串
/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = lengthOfLongestSubstring1(str);
        System.out.println("length:" + length);
    }

    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> windowSet = new HashSet<>();
        while (left < str.length() && right < str.length()) {
            if (windowSet.contains(str.charAt(right))) {
                windowSet.remove(str.charAt(left));
                left++;
            } else {
                windowSet.add(str.charAt(right));
                right++;
                int maxCurrentLength = right - left;
                maxLength = Math.max(maxLength, maxCurrentLength);
            }
        }
        return maxLength;

    }
    public static int lengthOfLongestSubstring1(String str) {
        int maxLength=0;
        int right=0;
        int left=0;
        Set<Character> windowSet=new HashSet();
        while(left<str.length()&&right<str.length()){
            if (windowSet.contains(str.charAt(right))) {
                windowSet.remove(str.charAt(left));
                left++;
            }else{
                windowSet.add(str.charAt(right));
                right++;
                int currentMaxLength=right-left;
                maxLength=Math.max(maxLength,currentMaxLength);
            }
        }
        return maxLength;
    }
}
