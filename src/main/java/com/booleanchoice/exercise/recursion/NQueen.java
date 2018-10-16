package com.booleanchoice.exercise.recursion;

/**
 * n皇后问题：
 * 在一个N*N的棋盘上摆放N个皇后，使其不能互相攻击，
 * 即要保证两个棋子不能同时出现在同一行、同一列、同一斜线上，问有多少种摆法。
 *
 */
public class NQueen {

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] queen = new int[n];
        return process(0, queen, n);
    }

    public static int process(int i, int[] queen, int n) {
        // 摆到第n行才算有一个解，也是递归的出口
        if (i == n) {
            return 1;
        }
        // 用于保存结果
        int res = 0;
        // 逐列验证
        for (int j = 0; j < n; j++) {
            if (isValid(queen, i, j)) {
                // 若符合验证则记录在棋子位置数组中
                queen[i] = j;
                // 递归调用，开始下一行的验证
                res += process(i + 1, queen, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] queen, int i, int j) {
        // 回溯以往记录，看符不符合条件，即不能出现在同一列和不能出现在同一斜线
        for (int k = 0; k < i; k++) {
            // 出现在同一列或同一斜线上不通过验证
            if (j == queen[k] || Math.abs(queen[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("8皇后问题解为：" + num(8));
    }

}
