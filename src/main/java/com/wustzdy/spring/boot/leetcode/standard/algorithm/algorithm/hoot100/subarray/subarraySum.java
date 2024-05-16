package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.subarray;

import java.util.HashMap;
import java.util.Map;

//和为K的子数组
// 1, 1, 1
// k=2
//https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247495053&idx=1&sn=b6926c7adc9dc7000175a63fb3e2e7cf&chksm=fb427eadcc35f7bb8bcb6ef0ab99f92d11690572e23c6a2291c5e1362aa1fdcdd3a51d69e25f&scene=27
//https://baijiahao.baidu.com/s?id=1764957727711830808&wfr=spider&for=pc
public class subarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int length = subarraySum3(nums, 3);
        System.out.println("length:" + length);

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    //https://baijiahao.baidu.com/s?id=1764957727711830808&wfr=spider&for=pc
    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int result = 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            result += map.getOrDefault(preSum[i + 1] - k, 0);
            map.put(preSum[i + 1], map.getOrDefault(preSum[i + 1], 0) + 1);
        }
        return result;
    }

    //standard
    public static int subarraySum3(int[] nums, int k) {
        // 前缀和数组
        int length = nums.length;
        int[] preSum = new int[length + 1];
        for (int i = 0; i < length; i++) {// 计算前缀和
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;// 统计和为 k 的子数组
        // 枚举所有子数组
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (preSum[j] - preSum[i] == k)
                    count++;
            }
        }
        return count;
    }
}
