package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.stack;

//字符串解码

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 */
/**
 * 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
 * 如果当前的字符为字母或者左括号，直接进栈
 * 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字，
 * 就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
 * 重复如上操作，最终将栈中的元素按照从栈底到栈顶的顺序拼接起来，就得到了答案。注意：这里可以用不定长数组来模拟栈操作，方便从栈底向栈顶遍历
 * */
//数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。就是逆波兰式那种题。
public class decodeString {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        String result = decodeString(str);
        System.out.println("result:" + result);
    }

    public static String decodeString(String s) {
        //"3[a]2[bc]"
        Deque<Integer> countStack = new ArrayDeque<>(); // 存储数字
        Deque<String> stringStack = new ArrayDeque<>(); // 存储字符串
        String currentString = ""; // 当前解码字符串
        int k = 0; // 当前的倍数

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // 处理多位数  //c-'0'表示字符转换为数字
            } else if (ch == '[') {
                // 遇到 '['，将当前的字符串和数字推入各自的栈
                countStack.push(k);
                stringStack.push(currentString);
                currentString = ""; // 重置当前字符串
                k = 0; // 重置倍数
            } else if (ch == ']') {
                // 遇到 ']'，解码
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString); // 重复当前字符串
                }
                currentString = temp.toString(); // 更新当前字符串
            } else {
                // 如果是字母，直接加到当前字符串
                currentString += ch;
            }
        }
        return currentString;
    }

}
