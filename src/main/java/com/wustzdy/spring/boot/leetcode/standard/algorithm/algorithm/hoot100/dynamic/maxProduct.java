package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;
//乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

/**
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * https://leetcode.cn/problems/maximum-product-subarray/solutions/7561/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/?envType=study-plan-v2&envId=top-100-liked
 */

/**
 * 标签：动态规划
 * 遍历数组时计算当前最大值，不断更新
 * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
 * 当负数出现时则imax与imin进行交换再进行下一步计算
 * 时间复杂度：O(n)O(n)O(n)
 */
public class maxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        int result = maxProduct1(nums);
        System.out.print("result:" + result);
    }

    //https://www.bilibili.com/video/BV1qM4m1Q7nZ/?spm_id_from=333.337.search-card.all.click&vd_source=5363405f0e14a0e8f06bcae41548f41e
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;

    }

    //https://www.bilibili.com/video/BV1EL4y1K7aw?spm_id_from=333.788.videopod.sections&vd_source=5363405f0e14a0e8f06bcae41548f41e
    //https://www.bilibili.com/video/BV1Ai4y1Z7gE/?spm_id_from=333.337.search-card.all.click&vd_source=5363405f0e14a0e8f06bcae41548f41e
    public static int maxProduct1(int[] nums) {
        //        2, 3, -2, 4
        //cur:    2  3  -2  4
        //pre_max:2  6  -2  4
        //pre_min:2  3  -12 -48
        if (nums == null || nums.length == 0)
            return 0;
        int res = nums[0];
        int pre_max = nums[0];
        int pre_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur=nums[i];
            int a = pre_max * cur;
            int b = pre_min * cur;
            pre_max = Math.max(cur, Math.max(a, b));
            pre_min = Math.min(cur, Math.min(a, b));
            res = Math.max(res, pre_max);
        }
        return res;
    }
}
