//3，爬楼梯
/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
*/
//再回顾一下dp[i]的定义：爬到第i层楼梯，有dp[i]种方法。

//在到达第n层的上一步，我们只有两个选择，走一步，或者走两步。
//    如果是走一步，我们需要先通过 f(n-1)种方式到达 n-1 层
//    如果是走两步， 我们需要通过 f(n-2)种方式到达第 n - 2 层
//    所以综上有 f(n) = f(n-2) + f(n-1)

import java.util.Arrays;

public static int jumpFloor(int number) {
    //n=3
    //dp[i]: 0 1 2 3
    int[] dp = new int[number + 1];//如果不初始化dp[0]，那就存数组的时候从1开始
    if (number == 1) {  //如果数组下标从1开始，那么这里1的情况就要单独加进去
        return 1;
    }
    dp[1] = 1;//到第一个台阶
    dp[2] = 2;//到第二个台阶
    for (int i = 3; i < number + 1; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[number];
}
//https://www.bilibili.com/video/BV16v41177GF/?spm_id_from=333.337.search-card.all.click&vd_source=5363405f0e14a0e8f06bcae41548f41e
/**
 * 我们只有两个选择，走一步，或者走两步。
 * 比如要走3步，那么必须要先到达第1步，或者第2步，所以f(3)=f(2)+f(1)
/*
//假设爬三阶楼梯
那么有两种方案
A,假设先跳1级，那么剩下的 2层，3层楼，
           有两种跳法，要么是一次跳1级，也就是先跳2层，再跳3层，
                     要么是一次跳2级，也就是一次性跨两步，就是跨2层
           综上所述：有2种方法
B,假设先跳2级，那么剩下的1层，那么只有1种跳法，也就是直接跳到3层

综合A，B两种选择 最后有3种方法
 * */
private static int getClimbStairsLayer(int n) {
    if (n == 1) {
        return 1;
    } else if (n == 2) {
        return 2;
    } else {
        return getClimbStairsLayer(n - 1) + getClimbStairsLayer(n - 2);
    }
}

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
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]输出：6
//* 题目中说 “你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯”
//也就是相当于 跳到 下标 0 或者 下标 1 是不花费体力的，
//从 下标 0 下标1 开始跳就要花费体力了。
/*dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。

确定递推公式
可以有两个途径得到dp[i]，一个是dp[i-1] 一个是dp[i-2]。
dp[i - 1] 跳到 dp[i] 需要花费 dp[i - 1] + cost[i - 1]。
dp[i - 2] 跳到 dp[i] 需要花费 dp[i - 2] + cost[i - 2]。
那么究竟是选从dp[i - 1]跳还是从dp[i - 2]跳呢？
一定是选最小的，所以dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
1）那么从i-1的位置到达i位置的最小费用为dp[i-1]+往上爬一步所需的费用为cost[i-1]。 dp[i]=dp[i-1]+cost[i-1]
2）同理，那么从i-2的位置到达i位置的最小费用为dp[i-2]+往上爬两步所需的费用为cost[i-2]。 dp[i]=dp[i-2]+cost[i-2]
*/
//https://blog.csdn.net/qq_68288689/article/details/131341822
//https://blog.csdn.net/qq_69369227/article/details/131528779?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-9-131528779-blog-127724999.235^v43^pc_blog_bottom_relevance_base3&spm=1001.2101.3001.4242.6&utm_relevant_index=12
public static int minCostClimbingStairs(int[] cost) {
    //dp 到达第i台阶所花费的最少体力为dp[i]。如果要向上跳，那么需要加上本身的花费const
    //int[] //2 5  20
    //下标：//0 1  2  3
    //dp[] //0 0  2  5
    int len = cost.length;//
    int[] dp = new int[len + 1];

    // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
    dp[0] = 0;
    dp[1] = 0;

    // 计算到达每一层台阶的最小费用
    for (int i = 2; i < len + 1; i++) {
        dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }
    return dp[len];
}

//杨辉三角
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
/*
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
*/
public static List<List<Integer>> generate1(int numRows) {
    // 初始化动态规划数组
    Integer[][] dp = new Integer[numRows][];
    // 遍历每一行
    for (int i = 0; i < numRows; i++) {
        // 初始化当前行
        dp[i] = new Integer[i + 1];
        // 每一行的第一个和最后一个元素总是 1
        dp[i][0] = dp[i][i] = 1;
        // 计算中间元素
        for (int j = 1; j < i; j++) {
            // 中间元素等于上一行的相邻两个元素之和
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }
    }

    // 将动态规划数组转换为结果列表
    List<List<Integer>> result = new ArrayList<>();
    for (Integer[] row : dp) {
        result.add(Arrays.asList(row));
    }
    // 返回结果列表
    return result;
}

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
        1 2 3 1
 */
public class rob {
      // 长度：   n=5
     // 下标:    0, 1, 2, 3, 4
    //  num[i]= 2, 7, 9, 3, 1
    //  dp [i]= 2, 7, 11,11,12
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int rob = rob(nums);
        System.out.println("rob:" + rob);//12
    }

    public static int rob(int[] nums) {
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

//完全平方数
/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4

输入：n = 13
输出：2
解释：13 = 4 + 9
*/
public static int numSquares3(int n) {
    //dp[i] 表示i的完全平方和的最少数量
    //下标：  0 1 2 3 4 5 6 7 8 9 10 11 12
    //dp[i]= 0 1 2 3 1 2 3 4 2 1  2  3  3
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 10);
    dp[0] = 0;
    for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
    }
    return dp[n];
}


//兑换零钱
/**
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
*/
/**
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
 */
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

// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
/**
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
 */
public static boolean wordBreak(String s, List<String> wordDict) {
    //前n个字符能否拆分 s = "leetcode", wordDict = ["leet", "code"]
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;
    for(int i=0; i<s.length(); i++){
        for(int j=i+1; j<=s.length();j++){
            if(dp[i]&& wordDict.contains(s.substring(i,j))){
                dp[j]=true;
            }
        }
    }
    return dp[s.length()];
}

//最长递增子序列 最长上升子序列 长度
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
/*
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
*/
public static int lengthOfLIS_new(int[] nums) {
    //初始化dp[i]: 1  1  1  1  1
    //len=5
    //数组下标：   0  1  2  3  4
    //原始数组num: 1, 5, 3, 4, 8
    //最终dp[i]:   1  2  2  3  4
    //上升子序列为   1 3 4 8 ,
    //故长度为4
    int len = nums.length;
    if (len == 0) {
        return 0;
    }
    int[] dp = new int[len];
    int res = 0;
    Arrays.fill(dp, 1);
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    //dp[i]=1  2  2  3  4,//求数组中最大值就可以
    res = Arrays.stream(dp).max().getAsInt();
    return res;
}
// 定义一个方法来找到数组中的最大元素
public static int findMax(int[] arr) {
    // 初始化最大值为数组的第一个元素
    int max = arr[0];

    // 遍历数组，从第二个元素开始比较
    for (int i = 1; i < arr.length; i++) {
        // 如果当前元素大于max，更新max
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // 返回最大值
    return max;
}

//674. 最长连续递增序列
// 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
/**
 *
输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

如果 nums[i] > nums[i - 1]，那么以 i 为结尾的连续递增的子序列长度 一定等于 以i - 1为结尾的连续递增的子序列长度 + 1 。
即：dp[i] = dp[i - 1] + 1;
 */
public static int findLengthOfLCIS1(int[] nums) {
    //n=5
    //下标：    0 1 2 3 4
    //nums[i]: 1,3,5,4,7
    //dp[i]:   1,2,3,1,2
    //求连续最长连续递增序列是 [1,3,5]长度，也就是求dp[i]中最大的数字
    int[] dp = new int[nums.length];
    Arrays.fill(dp,1);

    int res = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i-1]) {
            dp[i] = dp[i-1] + 1;
        }
    }
    res = Arrays.stream(dp).max().getAsInt();//也就是求dp[i]中最大的数字
    return res;
}
//718. 最长重复子数组
//https://programmercarl.com/0718.%E6%9C%80%E9%95%BF%E9%87%8D%E5%A4%8D%E5%AD%90%E6%95%B0%E7%BB%84.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 输入：
 * <p>
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3, 2, 1] 。
 */
public static int findLength(int[] nums1, int[] nums2) {
    int result = 0;
    int[][] dp = new int[nums1.length + 1][nums2.length + 1];

    for (int i = 1; i < nums1.length + 1; i++) {
        for (int j = 1; j < nums2.length + 1; j++) {
            if (nums1[i - 1] == nums2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
    }
    return result;
}
//1143.最长公共子序列
/**** https://programmercarl.com/1143.%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 输入：text1 = "abcde", text2 = "ace"
   输出：3
   解释：最长公共子序列是 "ace"，它的长度为 3。

   输入：text1 = "abc", text2 = "abc"
   输出：3
   解释：最长公共子序列是 "abc"，它的长度为 3。

   1，自己的斜对角+1，
    1  1
    1  2(所求)
   2，比较左边和上面哪个大？
    1 2
    1 2(所求)
 */
public static int longestCommonSubsequence_length(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
    for (int i = 1; i <= text1.length(); i++) {
        char char1 = text1.charAt(i - 1);
        for (int j = 1; j <= text2.length(); j++) {
            char char2 = text2.charAt(j - 1);
            if (char1 == char2) { // 开始列出状态转移方程
                dp[i][j] = dp[i - 1][j - 1] + 1; //自己的斜对角+1，
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);//比较左边和上面哪个大？
            }
        }
    }
    return dp[text1.length()][text2.length()];
}

//乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
/**
输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
https://leetcode.cn/problems/maximum-product-subarray/solutions/7561/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/?envType=study-plan-v2&envId=top-100-liked
*/
/**
 * 标签：动态规划
 * 遍历数组时计算当前最大值，不断更新
 * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
 * 当负数出现时则imax与imin进行交换再进行下一步计算
 * 时间复杂度：O(n)O(n)O(n)
 *
 * */
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



//分割等和子集
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
/**
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 */

//8，不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//问总共有多少条不同的路径？
//输入：m = 3, n = 7
//输出：28
/*示例 2：
        输入：m = 3, n = 2
        输出：3
        解释：
        从左上角开始，总共有 3 条路径可以到达右下角。
        1. 向右 -> 向下 -> 向下
        2. 向下 -> 向下 -> 向右
        3. 向下 -> 向右 -> 向下
*///然后只要让 dp[0][1] = 1 或者 dp[1][0] = 1 就可以了。格子都是有 右 和 上两个格的和
//这里要看一下递推公式dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，dp[i][j]都是从其上方和左方推导而来，那么从左到右一层一层遍历就可以了。
private static int uniquePathsFun(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        dp[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
    }
    return dp[m-1][n-1];
}

// 不同路径 II 有障碍物
/***
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */

//BM68 矩阵的最小路径和
//https://www.bilibili.com/video/BV1yN411d7Pr/
//输入：[[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
//输出：12
//             给定数组   dp数组
//         *  1 3 1  |   1 4 5 | 1 4 5
//         *  1 5 1  |   2     | 2 7 6
//         *  4 2 1  |   6     | 6 8 7
/*
 * i=0,也就是 如何 得到列 1 2 6----对应列
 *    2=dp[1][0]=dp[0][0]+matrix[1][0]=1+1=2
 *    6=dp[2][0]=dp[1][0]+matrix[2][0]=2+4=6
 *
 * j=0,也就是 如何 得到列 1 4 5----对应行
 *    4=dp[0][1]=dp[0][0]+matrix[0][1]=1+3=4
 *    5=dp[0][2]=dp[0][1]+matrix[0][2]=4+1=5
 *
 * dp[1][1]=min(dp[i-1][j],dp[i][j-1]+matrix[1][1];
 * */
public static int minPathSum1(int[][] matrix) {
    // write code here
    int m = matrix.length; // matrix的行 m=3
    int n = matrix[0].length;// matrix的列 n=3
    int[][] dp = new int[m][n];// dp[i][j]代表在第i行第j列最小的路径和为多少
    dp[0][0] = matrix[0][0];// 初始化dp[0][0]为matrix[0][0]
    for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i - 1][0] + matrix[i][0];// 初始化dp[i][0]
    }
    for (int i = 1; i < n; i++) {
        dp[0][i] = dp[0][i - 1] + matrix[0][i];// 初始化dp[0][i]
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            // dp[i][j] 就应该等于在dp[i - 1][j]、dp[i][j - 1]选一个最小的在和matrix[i][j]加和
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
        }
    }
    return dp[m - 1][n - 1];// 最终的结果为dp[n-1][m-1]即二维表的最右下角
}
public static int minPathSum(int[][] matrix) {
    // write code here
    // 行数
    int m = matrix.length;
    // 列数
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                continue;
            } else if (i == 0) {
                matrix[i][j] += matrix[i][j - 1];
            } else if (j == 0) {
                matrix[i][j] += matrix[i - 1][j];
            } else {
                matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
    }
    return matrix[m - 1][n - 1];
}
//647. 回文子串
/***
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
示例 1：
输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"

示例 2：
输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 */
public static int countSubstrings(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];

    int res = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                res++;
                dp[i][j] = true;
            }
        }
    }
    return res;
}

//5,//BM73 最长回文子串
//输入： "babad"
//    返回值： bab
//    说明： 最长的回文子串为"aba"与"bab"，长度都为3
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) {
        return "";
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

public int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        --left;
        ++right;
    }
    return right - left - 1;
}

//6，判断给定字符串是否是回文串 stanard
private static Boolean IsPalindromicString(String s) {
    s = "abcba";
    int n = s.length();
    int left = 0;
    int right = n - 1;

    while (left < right) {
        if (s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        } else {
            return false;
        }
    }
    return true;
}
//是否为回文字串
private static boolean isPalindromic(String s) {
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
        if (s.charAt(i) != s.charAt(len - i - 1)) {
            return false;
        }
    }
    return true;
}
//求回文字串的长度
private static int isPalindromicString1(String s, int left, int right) {
    int length = s.length();
    while (left > 0 && right < length) {
        if (s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        } else {
            break;
        }
    }
    return right - left - 1;
}

////5,//BM73 最长回文子串-暴力
//输入： "babad"
//    返回值： bab
//    说明： 最长的回文子串为"aba"与"bab"，长度都为3
public static String longestPalindrome(String s) {
    //存储最长子串
    String str = "";
    //存储最长长度
    int longest = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i+1; j < s.length() + 1; j++) {
            String str1 = s.substring(i, j);
            if (isPalindromes(str1) && str1.length()>longest) {
                str = str1;
                longest= str.length();
            }
        }
    }
    return str;
}

public static boolean isPalindromes(String str) {
    if (str.length() == 1) {
        return true;
    }
    for (int i = 0; i < str.length() / 2; i++) {
        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
            return false;
        }
    }
    return true;
}