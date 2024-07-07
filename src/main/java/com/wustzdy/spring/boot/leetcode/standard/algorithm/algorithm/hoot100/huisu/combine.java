package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.huisu;

import java.util.ArrayList;
import java.util.List;

/** 组合
 * 定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * #
 * //https://programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 * <p>
 * //直接的解法当然是使用for循环，例如示例中k为2，很容易想到 用两个for循环，这样就可以输出 和示例中一样的结果。
 */

public class combine {
    public static void main(String[] args) {
        test2();//1,2],[1,3],[1,4],[2,3],[2,4],[3,4],[
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println("combine:" + combine);//[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }

    public static void test2() {
        //直接的解法当然是使用for循环，例如示例中k为2，
        // 很容易想到 用两个for循环，这样就可以输出 和示例中一样的结果。
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.print(i + "," + j + "],[");
            }
        }
    }

    public static void test3() {
        //输入：n = 100, k = 3 那么就三层for循环，代码如下：
        int n = 100;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int u = j + 1; u <= n; n++) {
                    System.out.print(i + "," + j + "," + "],[");
                }
            }
        }
    }

    //standard
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(result, path, n, k, 1);
        return result;
    }

    public static void backtracking(List<List<Integer>> result,
                                    List<Integer> path,
                                    int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(result, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}



