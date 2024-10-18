package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

/*法一：
打家劫舍
动态规划
        首先考虑最简单的情况。如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，只能偷窃其中的一间房屋，因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额。
        如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k (k>2) 间房屋，有两个选项：
        1，偷窃第 k 间房屋，那么就不能偷窃第 k−1间房屋，偷窃总金额为前 k−2间房屋的最高总金额与第 k间房屋的金额之和。
        2，不偷窃第 k间房屋，偷窃总金额为前 k−1间房屋的最高总金额。
        在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 kkk 间房屋能偷窃到的最高总金额。

        用 dp[i]表示前 i间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        边界条件为：
        dp[0] = nums[0]; 只有一间房屋，则偷窃该房屋
        dp[1] = Math.max(nums[0], nums[1]);只有两间房屋，选择其中金额较高的房屋进行偷窃​

        最终的答案即为 dp[n−1]其中 nnn 是数组的长度。
        作者：力扣官方题解
        链接：https://leetcode.cn/problems/house-robber/solutions/263856/da-jia-jie-she-by-leetcode-solution/
 */
public class rob {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int rob = rob(nums);
        System.out.println("rob:" + rob);//12
    }

    public static int rob(int[] nums) {
        //          0, 1, 2, 3, 4
        //  num[i]= 2, 7, 9, 3, 1
        //  dp [i]= 2, 7, 11,11,12
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
