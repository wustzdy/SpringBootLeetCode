package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute1 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        combine(result, path, 7, 3, 1);
        System.out.print(result);

    }

    public static List<List<Integer>> combine(List<List<Integer>> result,
                                              LinkedList<Integer> path,
                                              int n,
                                              int k,
                                              int startIndex) {
        backtracking(result, path, n, k, startIndex);
        return result;
    }

    public static void backtracking(List<List<Integer>> result,
                                    LinkedList<Integer> path,
                                    int n,
                                    int k,
                                    int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(result, path, n, k, i + 1);
            path.removeLast();
        }
    }
}
