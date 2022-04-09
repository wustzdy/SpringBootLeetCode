package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220213;
//https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
/*
最大子序和https://blog.csdn.net/zwzsdy/article/details/80029796
设sum[i]为以第i个元素结尾且和最大的连续子数组。假设对于元素i，所有以它前面的元素结尾的子数组的长度都已经求得，那么以第i个元素结尾且和最大的连续子数组实际上，要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素，即sum[i]
= max(sum[i-1] + a[i], a[i])。可以通过判断sum[i-1] + a[i]是否大于a[i]来做选择，而这实际上等价于判断sum[i-1]是否大于0。由于每次运算只需要前一次的结果，因此并不需要像普通的动态规划那样保留之前所有的计算结果，只需要保留上一次的即可，因此算法的时间和空间复杂度都很小
* */

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
//最大子序列和的四种算法实现(循序渐进)
public class Test_06_MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {1,-2,4,5,-7,6,-4};
        int max = maxSubArray(nums);
        System.out.println("max: " + max);
    }
   /* 思路
    这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
    动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
    如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果*/
    //动态规划
    //若前一个元素大于0，则将其加入到当前元素上
    public static int maxSubArray(int[] arr) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            /*if (max < sum) {
                max = sum;
            }*/
            max = Math.max(sum, max);
        }
        return max;
    }

    /* 还有一种更简单的方法，我们只需要从数组的第一个数开始，依次加后面的数，
    一旦和为负数，就立即置为0，再继续加后面的数（第一个数也要判断是否是负数），
    因为一旦出现负数，有这一部分的序列必不可能是和最大的，因此把sum重新置为0，
    继续此循环，提示，带入实例更容易理解。
     代码如下（实例同算法三）：
             ————————————————
     版权声明：本文为CSDN博主「rikka-l」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     原文链接：https://blog.csdn.net/csdnwqy030429/article/details/120895492*/
    public static int subsequencesum_max(int[] arr) {
        int sum = 0, sum_max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > sum_max)
                sum_max = sum;
            else if (sum < 0)
                sum = 0;
        }
        return sum_max;
    }
}
