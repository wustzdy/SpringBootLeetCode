package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

//最小花费爬楼梯
/*旧题目描述：
        数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
        每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
        请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
        示例 1：
        输入：cost = [10, 15, 20]
        输出：15
        解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
        示例 2：
//4， 最小花费爬楼梯
/**
 * 输入：cost = [10, 15, 20]
   输出：15
   解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
           0  2  2 3 4 5  6 7 8  9
    输入： [1,100,1,1,1,90,1,1,80,1]
    返回值：6
    说明：
    你将从下标为 0 的台阶开始。
    1.支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
    2.支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
    3.支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
    4.支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
    5.支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
    6.支付 1 ，向上爬一个台阶，到达楼梯顶部。
    总花费为 6 。
 *
 */

/*
* 修改之后的题意就比较明确了，题目中说 “你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯”
* 也就是相当于 跳到 下标 0 或者 下标 1 是不花费体力的，
*  从 下标 0 下标1 开始跳就要花费体力了。
确定dp数组以及下标的含义
使用动态规划，就要有一个数组来记录状态，本题只需要一个一维数组dp[i]就可以了。

dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。
对于dp数组的定义，大家一定要清晰！

确定递推公式
可以有两个途径得到dp[i]，一个是dp[i-1] 一个是dp[i-2]。
dp[i - 1] 跳到 dp[i] 需要花费 dp[i - 1] + cost[i - 1]。
dp[i - 2] 跳到 dp[i] 需要花费 dp[i - 2] + cost[i - 2]。
那么究竟是选从dp[i - 1]跳还是从dp[i - 2]跳呢？
一定是选最小的，所以dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

dp数组如何初始化
看一下递归公式，dp[i]由dp[i - 1]，dp[i - 2]推出，既然初始化所有的dp[i]是不可能的，
* 那么只初始化dp[0]和dp[1]就够了，其他的最终都是dp[0]dp[1]推出。
* */
//https://blog.csdn.net/qq_68288689/article/details/131341822
//https://blog.csdn.net/qq_69369227/article/details/131528779?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-9-131528779-blog-127724999.235^v43^pc_blog_bottom_relevance_base3&spm=1001.2101.3001.4242.6&utm_relevant_index=12
public class minCostClimbingStairs {
    public static void main(String[] args) {
//        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = new int[]{2, 5, 20};
        int result = minCostClimbingStairs(cost);
        System.out.println("" + result);
    }

    public static int minCostClimbingStairs(int[] cost) {
        //dp 到达第i台阶所花费的最少体力为dp[i]。如果要向上跳，那么需要加上本身的花费const
        //int[]//2 5  20
               //0 1  2  3
        //dp[] //0 0  2  5
        int len = cost.length;//
        int[] dp = new int[len + 1];

        // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;

        // 计算到达每一层台阶的最小费用
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
