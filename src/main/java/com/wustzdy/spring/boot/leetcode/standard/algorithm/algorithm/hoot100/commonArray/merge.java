package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.commonArray;
//合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 先按区间起始值从小到大排序
 * 定义起点和终点遍历，起始值为第一个区间的左右值
 * 遍历数组，若当前区间起始位置大于第一个区间的结束位置，说明前一个区间可划分为一个单独区间，加入到结果中
 *
 */
public class merge {
    public static void main(String[] args) {

    }
    public static int[][] merge(int[][] intervals) {
        // 数组元素小于1就不用合并了
        if (intervals.length <= 1) return intervals;
        List<int[]> res = new ArrayList<>();
        // 按第一个元素排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int[] interval : intervals) {
            // 不能合并，就直接添加到list
            if (res.size() == 0 || interval[0] > res.get(res.size() - 1)[1]) {
                res.add(interval);
            } else {
                // 如果最后一个区间和当前区间重叠，就合并
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
