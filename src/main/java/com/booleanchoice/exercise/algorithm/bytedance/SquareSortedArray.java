package com.booleanchoice.exercise.algorithm.bytedance;

/**
 * 有序数组的平方
 *
 * 描述：
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 1. 1 <= A.length <= 10000
 * 2. -10000 <= A[i] <= 10000
 * 3. A 已按非递减顺序排序。
 *
 * 样例
 *
 * 示例1
 * 输入：
 * [-4,-1,0,3,10]
 * 输出：
 * [0,1,9,16,100]
 *
 * 示例2
 * 输入：
 * [-7,-3,2,3,11]
 * 输出：
 * [4,9,9,49,121]
 */
public class SquareSortedArray {

    /**
     * @param A: The array A.
     * @return: The array of the squares.
     */
    public int[] SquareArray(int[] A) {
        // write your code here
        if (null == A) {
            return null;
        }
        int[] rs = new int[A.length];
        if (A.length == 0) {
            return rs;
        }
        int leftIdx = 0;
        int rightIdx = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];

            int squared = num * num;

        }
        return null;
    }


}
