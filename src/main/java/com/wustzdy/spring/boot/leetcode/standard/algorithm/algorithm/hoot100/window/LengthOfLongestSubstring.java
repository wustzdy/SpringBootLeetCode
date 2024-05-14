package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.window;

import java.util.HashSet;
import java.util.Set;

//3. 无重复字符的最长子串
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
/*示例 1:
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
        解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。*/
//https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/by-sdwwld-t6wg/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("length: " + lengthOfLongestSubstring4(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        // 判断字符串参数的长度，小于2则直接返回
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        // 外层循环遍历每一个下标，以当前下标为起始点找出无重复的最长子串
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            StringBuffer sb = new StringBuffer();
            while (index < s.length()) {
                // 如果之前没出现过，则加进sb
                if (sb.indexOf(String.valueOf(s.charAt(index))) == -1) {
                    sb.append(s.charAt(index));
                    res = res > sb.length() ? res : sb.length();
                } else {
                    // 如果出现过则退出内循环，继续下一个外层循环
                    break;
                }
                index++;
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int index = -1; // 滑动窗口左侧
        for (int i = 0; i < s.length(); i++) { // i 为右侧
            // 除第一个元素外，每次移除上个左边界
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 右边界一直遍历到不包含重复元素的最大值
            while (index + 1 < s.length() && !set.contains(s.charAt(index + 1))) {
                set.add(s.charAt(index + 1));
                index++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    // 滑动窗口
    public int lengthOfLongestSubstring3(String s) {
        //窗口的最大长度
        int maxLength = 0;
        //窗口集合
        Set<Character> window = new HashSet<>();
        int left = 0;// 窗口的左边界
        int right = 0;// 窗口的右边界
        while (right < s.length()) {
            // 如果窗口中包含当前元素，说明出现了重复，
            // 把窗口最左端的给移除掉，直到窗口不包含当前元素即可
            while (window.contains(s.charAt(right)))
                window.remove(s.charAt(left++));
            //把当前元素添加到窗口中
            window.add(s.charAt(right++));
            //更新窗口的长度
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
    //https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/ren-zhe-suan-fa-7fen-zhong-bai-ban-dai-m-0u35/

    /**
     * 什么是滑动窗口？
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     * 如何移动？
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     */
    public static int lengthOfLongestSubstring4(String s) {
        int maxLength = 0;//abcabcbb
        int left = 0;
        int right = 0;
        Set<Character> windowSet = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            if (windowSet.contains(s.charAt(right))) {
                windowSet.remove(s.charAt(left));
                left++;
            } else {
                windowSet.add(s.charAt(right));
                right++;
                int currentMaxLength = right - left;
                maxLength = Math.max(maxLength, currentMaxLength);
            }
        }
        return maxLength;
    }
}
