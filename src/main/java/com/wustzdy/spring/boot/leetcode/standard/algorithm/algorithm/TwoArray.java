package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//二维数组初始化
public class TwoArray {
    public static void main(String[] args) {
        int[][] numseven = new int[][]{{10, 20, 30}, {40, 50}, {60}};
        //1，
        int[][] array = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int array1[][] = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] array2 = {{1, 2}, {2, 3}, {4, 5}};
        int rowLen = array2.length;
        int colLen = array2[0].length;

        System.out.println("rowLen: " + rowLen);
        System.out.println("colLen: " + colLen);


        System.out.println("三行两列的二维数组：");
        int sum = 0;
        for (int i = 0; i < array2.length; i++) { //外循环 执行输出每一列元素

            for (int j = 0; j < array2[i].length; j++) { //内循环 执行输出每一行元素
                sum += array2[i][j];
                System.out.print(array2[i][j] + " ");
            }
            System.out.println(); //每一行完成换列
        }
        System.out.println("元素总和：" + sum);


        //2,即声明时即分配内存的方式
        int[][] array3 = new int[3][4];

        //3,先声明再分配内存的方式
        int[][] array4 = null;
        array4 = new int[4][5];

        //4,
        int[][] arr3 = new int[5][];

    }
}
