package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
// 如果气温在这之后都不会升高，请在该位置用 0 来代替。
public class dailyTemperatures {
    public static void main(String[] args) {
//        int[] T = new int[]{30, 40, 50, 60};
        int[] T = new int[]{3, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures3(T);
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        //30,40,50,60
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 1000) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static int[] dailyTemperatures1(int[] T) {
        ////30,40,50,60
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] dailyTemperatures2(int[] T) {
        ////30,40,50,60
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            int j = i + 1;
            while (j < length) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
                j = j + result[j];
            }
        }
        return result;
    }

    /**
     *
     * 这里我们可以采用一个栈，来记录之前的温度（记录的是低温），然后遍历数组，发现如果今天的温度大于栈顶存储的温度，
     * 则将今天温度的数组下标和栈顶的相减获得天数差值，然后存入answer数组即可。
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures3(int[] temperatures) {
        //3, 74, 75, 71, 69, 72, 76, 73
        // 记录数组长度
        int length = temperatures.length;
        // 准备需要返回的数组
        int[] answer = new int[length];
        // 准备一个栈来存储
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            // 获取每次的温度
            int temperature = temperatures[i];
            // 若栈不为空而且，当前温度大于栈顶的温度（这里会一直查找）弹出栈，获取下标差值
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                // 获取栈顶元素
                int preIndex = stack.pop();
                // 取得下标差值，写入answer数组
                answer[preIndex] = i - preIndex;
            }
            // 存入栈
            stack.push(i);
        }
        return answer;
    }
}
