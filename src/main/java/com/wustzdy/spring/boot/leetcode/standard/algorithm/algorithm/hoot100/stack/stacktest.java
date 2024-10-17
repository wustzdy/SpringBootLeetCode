package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class stacktest {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('1');
        stack.push('2');
        stack.push('3');
        System.out.println(stack);//[1, 2, 3]

        Character peek = stack.peek();
        System.out.println(peek);//3 返回栈顶元素

        Character pop = stack.pop();//弹出栈顶元素
        System.out.println("pop:" + pop);//3

        System.out.println("stack:" + stack);//[1, 2]

    }

    public static void test1() {
        Deque<Character> stack = new LinkedList<>();//栈操作--JDK官方已建议优先使用Deque的实现类来代替Stack。
        Deque<Character> stack1 = new ArrayDeque<>();
        stack.push('1');
        stack.push('2');
        stack.push('3');
        System.out.println(stack);//[3, 2, 1]

        Character peek = stack.peek();
        System.out.println(peek);//3 返回栈顶元素

        Character pop = stack.pop();//弹出栈顶元素
        System.out.println("pop:" + pop);//3

        System.out.println("stack:" + stack);//[2, 1]

    }
}
