package com.booleanchoice.exercise.algorithm.sort;

/**
 * @author liujianzhao
 *
 * 快速排序，是对冒泡排序的改进，其基本思想为:
 * 一趟排序中，选择一个基准数，使基准数左边的数都小于它，
 * 右边的数都大于它，再继续排序左右两个区间。
 */
public class QuickSort {

    public static void quickSort(int[] s, int l, int r) {
        if (l < r) {
            // x为基准数，i、j为左右两指针
            int x = s[l], i = l, j = r;
            while (i < j) {
                // 挑一个右边比基准数小的数，放在"坑中"
                while (i < j && s[j] >= x)
                    j--;
                if (i < j) {
                    // ***把该数放在放在"坑中"，此时坑变为了s[j]的位置
                    s[i] = s[j];
                    // 左指针右移一位
                    i++;
                }
                // 挑一个左边比基准数大的数，放在"坑中"
                while (i < j && s[i] < x)
                    i++;
                if (i < j) {
                    // ***把该数放在放在"坑中"，此时坑变为了s[i]的位置
                    s[j] = s[i];
                    // 右指针左移一位
                    j--;
                }
            }
            // 此时 i与j相等 把基准数放到坑中
            s[i] = x;
            // 递归排序左右两个区间
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 6, 1, 2, 5};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "　");
        }
    }

}
