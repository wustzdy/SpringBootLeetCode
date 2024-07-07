package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.commonArray;
//缺失的第一个正数

import java.util.HashSet;
import java.util.Set;

//缺失的第一个正数

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 方法一：哈希表（空间复杂度不符合要求）
 * 按照刚才我们读例子的思路，其实我们只需从最小的正整数 111 开始，依次判断 222、 333 、444 直到数组的长度 NNN 是否在数组中；
 * 如果当前考虑的数不在这个数组中，我们就找到了这个缺失的最小正整数；
 * https://leetcode.cn/problems/first-missing-positive/solutions/1/tong-pai-xu-python-dai-ma-by-liweiwei1419/
 */
public class firstMissingPositive {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 0};
        int[] nums = new int[]{3, 4, -1, 1};
        int result = firstMissingPositive(nums);
        System.out.print("result:" + result);

    }

    public static int firstMissingPositive(int[] nums) {
        //3,4,-1,1
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        // -1 1 3 4

        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return len + 1;
    }
}
