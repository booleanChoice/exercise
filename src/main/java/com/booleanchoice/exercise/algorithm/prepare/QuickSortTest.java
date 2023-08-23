/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import java.util.Arrays;

/**
 * @author booleanchoice
 * @version QuickSortTest.java, v 0.1 2023年08月23日 10:05 booleanchoice
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 2, 2, 6, 1, 2, 5};
        quickSort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 递归出口
        if (left < right) {

            // 选基准
            int x = arr[left];
            int i = left;
            int j = right;

            while (i < j) {
                // 从右往左，找比基准小的
                while (i < j && arr[j] >= x)  {
                    j--;
                }
                // 把小的放在左边，此时坑变为j位置
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                // 从左往右，找比基准大的
                while (i < j && arr[i] <= x)  {
                    i++;
                }
                // 把大的放在右边，此时坑变为i位置
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }

            }
            // 最后i=j
            // 把基准放到坑里
            arr[i] = x;
            // 递归排基准左右双区间
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}