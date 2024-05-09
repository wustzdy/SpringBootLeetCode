package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100;

import java.util.HashSet;
import java.util.Set;

//128. 最长连续序列
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
// 示例 1：
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//根据本题的描述，一般来说，最容易想到的就是先将nums进行排序，然后再从排序后的数组头部开始遍历，
//        如果存在nums[i]+1，则进行加1计数。只要不存在nums[i]+1，则从0开始重新执行计数操作。
//        那么，每当发生了“断点”，
//        则通过result = Math.max(result, count)来更新result值（result表示最长数字连续序列个数）。
public class longestConsecutive {
    public static void main(String[] args) {
        int[] arrays = new int[]{100, 4, 200, 1, 3, 2};
        int size = longestConsecutive1(arrays);
        System.out.println("size:" + size);
    }
    //https://baijiahao.baidu.com/s?id=1764759781447590028&wfr=spider&for=pc
    //[case1]如果nums[i]+1在set中存在，则表示nums[i]不是连续序列的最大值，那么我们继续向下遍历，不用做任何操作；
//[case2]如果nums[i]+1在set中不存在，则表示nums[i]是连续序列的最大值，那么我们执行倒序查找set中的元素，即：依次寻找nums[i]--的元素，并进行计数操作。
    public static int longestConsecutive1(int[] nums) {
        //100, 4, 200, 1, 3, 2
        int result = 0;
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num + 1)) {
                int max = 0;
                while (set.contains(num)) {
                    max++;
                    num--;
                }
                result = Math.max(result, max);
            }
        }
        return result;
    }
}
