package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100;

////最大子序列和
public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println("max: " + max);
    }

    /* 思路
    这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
    动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 max
    如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    每次比较 sum 和 max的大小，将最大值置为max，遍历结束返回结果*/
    //动态规划
    //若前一个元素大于0，则将其加入到当前元素上
    public static int maxSubArray(int[] arr) {
        //-2, 1, -3, 4, -1, 2, 1, -5, 4
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
