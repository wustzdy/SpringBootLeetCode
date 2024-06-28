package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.twopoint;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {

        int[] array = new int[]{100, 4, 200, 1, 2, 3};
        int result = sumTest(array);
        System.out.println("result:" + result);

        for (int num : array) {
            if (num == 4)
                break;
            System.out.println("num:" + num);
        }
    }

    private static int sumTest(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int result = 0;
        for (int num : array) {
            if (!set.contains(num + 1)) {
                int max = 0;
                while (set.contains(num)) {
                    num--;
                    max++;
                }
                result = Math.max(max, result);
            }
        }
        return result;
    }
}
