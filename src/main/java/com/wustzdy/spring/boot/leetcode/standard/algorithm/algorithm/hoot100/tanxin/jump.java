package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.tanxin;

//跳跃游戏2
// 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

/**
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class jump {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int result = jump(nums);
        System.out.print("result:" + result);

    }

    //https://www.bilibili.com/video/BV1i5411o7wi/?spm_id_from=333.337.search-card.all.click&vd_source=5363405f0e14a0e8f06bcae41548f41e
    //https://leetcode.cn/problems/jump-game-ii/solutions/9347/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/?envType=study-plan-v2&envId=top-100-liked
    public static int jump(int[] nums) {
        //2, 3, 1, 1, 4
        int end = 0;//上次可跳跃的达到右边界
        int maxPos = 0;//当前能走到的最远位置
        int ans = 0;//结果变量
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPos = Math.max(maxPos, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}
