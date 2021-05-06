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
 *
 * 思路：
 * 输入数组内部平方后，都为正整数或0，故排序只需要看内部数的绝对值
 * 而且输入数组是有序数组，说明内部从0开始，负数从左到右逐渐增大，正数从右到左逐渐增大
 * 故首先分别从输入数组最左和最右记录索引
 * 比较最左和最右的绝对值大小，较大的那个就是平方后最大的数
 * 并不断把指针向中间收敛
 */
public class SquareSortedArray {

    /**
     * @param A: The array A.
     * @return: The array of the squares.
     */
    public int[] SquareArray(int[] A) {
        // write your code here
        int[] rs = new int[A.length];
        int leftIdx = 0;
        int rightIdx = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[leftIdx]) < Math.abs(A[rightIdx])) {
                int num = A[rightIdx] * A[rightIdx];
                rs[i] = num;
                rightIdx--;
            } else {
                int num = A[leftIdx] * A[leftIdx];
                rs[i] = num;
                leftIdx++;
            }
        }
        return rs;
    }

}
