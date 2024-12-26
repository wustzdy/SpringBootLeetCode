package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.test;

import java.util.Random;

public class FindTwoZeros {
    public static void main(String[] args) {
        int[] array = new int[100];
        // 初始化数组为1到100的自然数
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        // 打乱数组顺序
        shuffleArray(array);
        // 随机将两个数置为0
        int[] zeroIndices = getRandomIndices(2);
        array[zeroIndices[0]] = 0;
        array[zeroIndices[1]] = 0;

        // 打印打乱后的数组
        System.out.println("打乱后的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 找出这两个数
        int[] missingNumbers = findTwoZeros(array);
        System.out.println("两个被置为0的数是: " + missingNumbers[0] + " 和 " + missingNumbers[1]);
    }

    // 打乱数组顺序
    private static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // 交换元素
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // 随机生成两个不同的索引
    private static int[] getRandomIndices(int count) {
        Random rand = new Random();
        int[] indices = new int[count];
        for (int i = 0; i < count; i++) {
            int randomIndex;
            do {
                randomIndex = rand.nextInt(100);
            } while (contains(indices, randomIndex));
            indices[i] = randomIndex;
        }
        return indices;
    }

    // 检查数组中是否包含某个值
    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // 找出两个被置为0的数
    private static int[] findTwoZeros(int[] array) {
        long sum1To100 = 5050; // 1到100的和
        long sumOfSquares1To100 = 338350; // 1到100的平方和

        long sumArray = 0;
        long sumOfSquaresArray = 0;
        for (int num : array) {
            sumArray += num;
            sumOfSquaresArray += (long) num * num;
        }

        long sumMissing = sum1To100 - sumArray; // x + y
        long sumOfSquaresMissing = sumOfSquares1To100 - sumOfSquaresArray; // x^2 + y^2

        // 解方程组
        // x + y = sumMissing
        // x^2 + y^2 = sumOfSquaresMissing
        // 2xy = (x + y)^2 - (x^2 + y^2)
        long productMissing = (sumMissing * sumMissing - sumOfSquaresMissing) / 2;

        // 通过求根公式解方程
        double x = (sumMissing + Math.sqrt(sumMissing * sumMissing - 4 * productMissing)) / 2;
        double y = sumMissing - x;

        return new int[]{(int) Math.round(x), (int) Math.round(y)};
    }
}