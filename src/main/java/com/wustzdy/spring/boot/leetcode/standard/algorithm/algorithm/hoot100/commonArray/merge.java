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
        int[][] intervals=new int[][]{{1,4},{4,5}};
        int[][] merge =merge(intervals);

    }
    //https://leetcode.cn/problems/merge-intervals/solutions/1078627/56-he-bing-qu-jian-jian-dan-yi-dong-liao-uxbo/?envType=study-plan-v2&envId=top-100-liked
    public static int[][] merge(int[][] intervals) {
        // 数组元素小于1就不用合并了
        if (intervals.length <= 1)
            return intervals;
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
/*
    首先把数组排序，先按照起点升序排列，如果起点位置相同，按照结尾升序排序。
    设置start 和 end 为当前区间的开始和结尾。
    遍历intervals，如果下一个的起点小于当前区间的结尾，那么就说明这两个区间有重叠，要进行合并，所以要更新结尾，
     end = Math.max(end, intervals[i + 1][1])
    如果下一个的起点，大于当前区间的结尾，说明这两个区间没有重叠。之前start，end是一个单独的区间，所以保存起来。保存之后，
    重新设置strat和end，继续向后进行合并。
    举例：[[1,3],[2,6],[8,10],[15,18]]
    1、最开始start = 1和 end = 3
    2、到[2,6]，发现2（新的开始） < 3（上一个的结尾），证明这两个节点直接有重叠要合并，合并之后的结尾end = Math.max(3, 6) = 6。
    3、到[8, 10]，发现8（新的开始） > 6（上一个的结尾），说明这两个区间没有交集，此时要保存[start, end]即[1,6]，这是前两个区间合并的结果。 保存之后，更新start = 8， end = 10；
    4、到[15, 18]， 发现15 > 10， 说明这两个区间没有交集，要保存[start,end]即[8,10]，这是上一个不重叠的区间。然后更新start = 15, end = 18。
    5、遍历结束，保存当前的[start,end]，这是最后一个区间
*/
    //作者：Blizzard0409
    //链接：https://leetcode.cn/problems/merge-intervals/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static int[][] merge11(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= end){//两个区间有重叠
                end = Math.max(end, intervals[i][1]);
            }else{
                //两个区间没有重叠，保存[start,end]，然后更新
                ans.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[] {start, end});
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static int[][] merge2(int[][] a) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(a, (x, y)-> x[0] - y[0]);
        int l = a[0][0], r = a[0][1];
        for(int i = 1; i < a.length; i++){
            if(a[i][0] > r){
                //两个区间没有重叠，保存[start,end]，然后更新
                res.add(new int[]{l, r});
                l = a[i][0];
                r = a[i][1];
            }else{
                ////两个区间有重叠
                r = Math.max(r, a[i][1]);
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[0][]);
    }
}
