package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 * 示例 1：
 * <p>
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 * <p>
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A". 
 * "B" -> "C" -> "A". 
 * "C" -> "A". 
 * "A". 
 * 显然，旅行终点站是 "A"
 * 示例 3：
 * <p>
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 */
public class Solution {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        String[] strs1 = {"B", "C"};
        String[] strs2 = {"D", "B"};
        String[] strs3 = {"C", "A"};

        List<String> list1 = Arrays.asList(strs1);
        List<String> list2 = Arrays.asList(strs2);
        List<String> list3 = Arrays.asList(strs3);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        System.out.println("lists:" + lists);

        String tempStr = getSolution(lists);
        System.out.println("tempStr:" + tempStr);
    }

    private static String getSolution(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        // 将所有路径的起点与终点存入map
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        for (String s : map.keySet()) {
            // 如果某个路径的终点不是另一个路径的起点，则该点就是旅行终点
            if (map.get(map.get(s)) == null)
                return map.get(s);
        }
        // 返回默认null，由题意是不会走到这里返回的
        return null;
    }
}
