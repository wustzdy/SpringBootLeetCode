package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
/*
输入：s = "()"
输出：true

输入：s = "()[]{}"
输出：true

输入：s = "(]"
输出：false
*/

/*
具体思路是遍历字符串中的每个字符，当遇到左括号时，将其对应的右括号入栈；当遇到右括号时，与栈顶元素比较，如果匹配则将栈顶元素出栈，否则返回 false。
最后检查栈是否为空，如果为空则表示字符串有效，否则表示字符串无效。
作者：GoAhead
链接：https://leetcode.cn/problems/valid-parentheses/solutions/2751506/pythonjava-you-xiao-de-gua-hao-by-goahea-x03w/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class isValidKuohao {
    public static void main(String[] args) {
        String str = "()[]{}";
        boolean valid = isValid(str);
        System.out.println(valid);
    }

    public static boolean isValid1(String s) {
//        s="(}";
        //str = "()[]{}";
        Deque<Character> stack = new LinkedList<>();
        for (char i : s.toCharArray()) {
            if (i == '(') {
                stack.push(')');
            } else if (i == '[') {
                stack.push(']');
            } else if (i == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != i) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
