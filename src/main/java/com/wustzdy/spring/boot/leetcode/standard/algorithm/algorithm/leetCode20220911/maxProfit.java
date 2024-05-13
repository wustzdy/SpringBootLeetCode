package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//JZ63 买卖股票的最好时机(一)
/*描述
        假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
        1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
        2.如果不能获取到任何利润，请返回0
        3.假设买入卖出均无手续费

        数据范围： 0≤n≤105,0≤val≤1040≤n≤105,0≤val≤104
        要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
        示例1
        输入：

        [8,9,2,5,4,7,1]
        返回值：
        5
        说明：
        在第3天(股票价格 = 2)的时候买入，在第6天(股票价格 = 7)的时候卖出，最大利润 = 7-2 = 5 ，不能选择在第2天买入，第3天卖出，这样就亏损7了；同时，你也不能在买入前卖出股票。

        示例2
        输入：
        [2,4,1]
        返回值：
        2

        示例3
        输入：
        [3,2,1]
        返回值：
        0
*/

public class maxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{8, 9, 2, 5, 4, 7, 1};
        int maxPro = getMaxProfit2(prices);
        System.out.println("maxPro:" + maxPro);
    }

    private static int getMaxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int maxProfit = prices[j] - prices[i];
                if (maxProfit > max) {
                    max = maxProfit;
                }
            }
        }
        return max;
    }

    private static int getMaxProfit2(int[] prices) {
        //8, 9, 2, 5, 4, 7, 1
        int max = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[i] - prices[j]);
            }
        }
        return max;
    }

    private static int getMaxProfit1(int[] prices) {
        int mi = 0x3f3f3f3f; // 初始化我们遍历得到的最小值
        int maxProfit = 0;
        for (int x : prices) {
            // 在遍历的过程中，不断更新我们的最小值
            mi = Math.min(mi, x);
            // 然后维护获得的最大收益
            maxProfit = Math.max(maxProfit, x - mi);
        }
        return maxProfit;
    }
}
