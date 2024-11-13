package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.deap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//前K个高频元素
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
/*
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

输入: nums = [1], k = 1
输出: [1]
*/

/**
 * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
 * 维护一个元素数目为 k 的最小堆
 * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
 * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
 * 最终，堆中的 k 个元素即为前 k 个高频元素
 * 原文链接：https://blog.csdn.net/cckluv/article/details/114003735
 */
public class topKFrequent {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent1(array, k);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counter = IntStream.of(nums).boxed()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 定义小根堆，根据数字频率自小到大排序
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
        // 遍历数组，维护一个大小为 k 的小根堆：
        // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
        counter.forEach((num, cnt) -> {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (counter.get(pq.peek()) < cnt) {
                pq.poll();
                pq.offer(num);
            }
        });
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;

    }

    public static int[] topKFrequent1(int[] nums, int k) {
        //// 统计每个数字出现的次数
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // 如果哈希表中没有这个元素就赋值为1
        // 如果哈希表有这个元素就把数值加1
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // 1=3 2=2 3=1
        // // 使用最小堆来保存频率前k高的元素（使用自定义比较器）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        // 遍历HashMap，将元素加入最小堆中
        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
