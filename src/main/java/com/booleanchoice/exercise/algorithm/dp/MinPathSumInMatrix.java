package com.booleanchoice.exercise.algorithm.dp;


/**
 * DP问题：矩阵的最小路径和
 * 问题描述：给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有数字累加起来就是路径和，返回所有路径中最小的路径和。
 */
public class MinPathSumInMatrix {

    public static int minPathSum(int[][] m) {
        // 判空
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        // 矩阵的行数
        int row = m.length;
        // 矩阵的列数
        int col = m[0].length;
        // 声明一个和m相等大小的状态矩阵dp
        int[][] dp = new int[row][col];
        // 左上角的值是一样的
        dp[0][0] = m[0][0];
        // 先计算第一列的路径和
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        // 再计算第一行的路径和
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        // 计算其他位置路径和
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        // 右下角即为解
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 1}};
        System.out.println("最小的路径和:" + minPathSum(m));
    }

}
