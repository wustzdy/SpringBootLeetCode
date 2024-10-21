package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.dynamic;

import java.util.Arrays;
//兑换零钱
/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */

/**
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
/*
解题方法
首先，我们定义一个一维数组 dp，其中 dp[i] 表示凑齐金额 i 所需的最少硬币数量。我们将数组初始化为 amount + 1，
因为凑齐 amount 最多需要 amount 枚1元硬币。接下来，我们从1遍历到目标金额 amount，
对于每个金额 i，再遍历可用的硬币面额 coins[j]。如果 i >= coins[j]，则更新 dp[i] = min(dp[i], dp[i - coins[j]] + 1)。
最终返回 dp[amount] 大于 amount 的话返回 -1，否则返回 dp[amount]。

重点理解
dp[i] = Math.min(dp[i], dp[i - coin] + 1);
这行代码中，dp 数组是一个动态规划数组，用于记录凑成金额 i 所需的最少硬币数量。dp[i] 表示凑成金额 i 的最小硬币数量。
对于每一个遍历到的硬币面额 coin，我们检查是否可以从之前已经计算过的较小金额 i - coin 继续凑成当前金额 i。如果可以，即 i >= coin，
那么我们只需要在原来凑成 i - coin 的基础上再增加一枚当前硬币即可，即原本的数量 dp[i - coin] 加上 1。

然后我们需要将这个新的可能结果与之前已知的最少硬币数 dp[i] 进行比较，取其中的最小值赋给 dp[i]。这样，经过所有硬币面额的迭代后，dp[i] 中记录的就是凑成金额 i 的最少硬币数量。

作者：暮色沙漠鱼
链接：https://leetcode.cn/problems/coin-change/solutions/2704416/322-ling-qian-dui-huan-dong-tai-gui-hua-872mv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
public class coinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        int result = coinChange1(coins, amount);
        System.out.print("result:" + result);
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - coins[j] >= 0 && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

    //https://www.bilibili.com/video/BV1e64y1P7MQ/?spm_id_from=333.337.search-card.all.click&vd_source=5363405f0e14a0e8f06bcae41548f41e
    public static int coinChange1(int[] coins, int amount) {
        //coins: 1 2 5
        //amount: 11
        //其中dp[i]表示凑成金额i所需的最少硬币个数
        int[] dp = new int[amount + 1];
        // 初始化数组的所有元素
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;// 金额0需要0枚硬币
        // 遍历从1到目标金额的每个金额
        for (int i = 1; i < amount + 1; i++) {
            // 遍历每个可用的硬币面额。
            for (int coin : coins) {
                // 如果当前金额大于等于硬币面额，尝试更新当前金额的最少硬币数。
                if (i >= coin) {
                    // 取当前金额最少硬币数和当前金额减去硬币面额的最少硬币数加1的最小值。
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);//'i-coin'表示从总金额中减去当前硬币面额后的剩余金额。
                }
            }
        }

        // 修正结果，如果amount无法凑成（即为极大值），返回-1
        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public static int coinChange2(int[] coins, int amount) {//125
        //dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
//    不装i即需要到前i-1个里面选，也就是前i-1行j背包容量下的最大价值，同理，由于前面都已经是最优解，直接查表a【i-1】【j】就是不装i条件下的最大价值
}


/**
 * 另一种实现
 * memo[i 有两种实现的方式，去两者的最小值
 * <p>
 * 包含当前的 coins[i]，那么剩余钱就是 i−coins[i]，这种操作要兑换的硬币数是memo[i−coins[j]]+1
 * <p>
 * 不包含，要兑换的硬币数是 memo[i]
 * <p>
 * Java
 * <p>
 * <p>
 * 作者：sugar
 * 链接：https://leetcode.cn/problems/coin-change/solutions/137661/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */