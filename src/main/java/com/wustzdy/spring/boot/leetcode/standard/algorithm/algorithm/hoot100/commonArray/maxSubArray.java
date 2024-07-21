package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.commonArray;

////最大子序列和
//https://leetcode.cn/problems/maximum-subarray/solutions/1/53-zui-da-zi-shu-zu-he-dong-tai-gui-hua-bvkq9/?envType=study-plan-v2&envId=top-100-liked
public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray4(nums);
        System.out.println("max: " + max);//6
    }

    /* 思路
    这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
    动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 max
    如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    每次比较 sum 和 max的大小，将最大值置为max，遍历结束返回结果*/
    //动态规划
    //若前一个元素大于0，则将其加入到当前元素上
    //连续子数组 [4,-1,2,1] 的和最大，为 6 。
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

    //https://www.bilibili.com/video/BV1aY4y1Z7ya/?spm_id_from=333.788&vd_source=5363405f0e14a0e8f06bcae41548f41e
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > sum) {
                sum = count;
            }
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }

    public int maxSubArray3(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    //动态规划 standard
    public static int maxSubArray4(int[] nums) {
        //-2,1,-3,4,-1,2,1,-5,4
        int[] dp = new int[nums.length];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else { //若前一个元素大于0，则将其加入到当前元素上
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
