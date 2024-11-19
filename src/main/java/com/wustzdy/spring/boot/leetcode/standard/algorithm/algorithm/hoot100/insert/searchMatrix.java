package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.insert;

//搜索二维矩阵
/* 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
*  输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   输出：true
   *
   * 1  3  5  7
   * 10 11 16 20
   * 23 30 34 60
* */
public class searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}};
        boolean result = searchMatrix(matrix, 3);
        System.out.println("result:" + result);

    }

    //https://leetcode.cn/problems/search-a-2d-matrix/solutions/536366/yi-wen-dai-ni-gao-ding-duo-ge-er-fen-cha-2hl9/?envType=study-plan-v2&envId=top-100-liked
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1, columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }
}

/*
* 2）找出mid，该索引为 mid =（left + right）/ 2，但是这样写有可能溢出，所以我们需要改进一下写成

mid = left +（right - left）/ 2 或者 left + ((right - left ) >> 1) 两者作用是一样的，都是为了找到两指针的中

间索引，使用位运算的速度更快。那么此时的 mid = 0 + (8-0) / 2 = 4

作者：袁记菜馆
链接：https://leetcode.cn/problems/search-a-2d-matrix/solutions/536366/yi-wen-dai-ni-gao-ding-duo-ge-er-fen-cha-2hl9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */