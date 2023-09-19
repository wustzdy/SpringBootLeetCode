package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

import java.util.HashMap;
import java.util.Map;

public class Ksum {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1,2, 1,};
        int result = numberOfSubarrays(array, 2);


        System.out.println("result:" + result);


    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        //一次遍历
        for (int i = 0; i < nums.length; ++i) {
            //存在时，我们用数组得值为 key，索引为 value
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            //存入值
            map.put(nums[i], i);
        }
        //返回
        return new int[]{};
    }

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        int count = 0;
        //双重循环
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                sum += nums[j];
                //发现符合条件的区间
                if (sum == k) {
                    count++;
                }
            }
            //记得归零，重新遍历
            sum = 0;
        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        //输入：[3,1,1,0] k = 2时则不会漏掉
        //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : nums) {
            presum += x;
            //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);//获取次数
            }
            //更新
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        // k-v k:前缀和（有N个奇数） v：有N个奇数的情况有几种（本题比较特殊，全是1种）
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            if (num % 2 != 0) {//判断是否为奇数
                preSum++;
            }
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            if (map.containsKey(preSum)) {//这个if 在这题中其实没用，只是为了保证模板完整性还是写了
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return count;

    }

}
