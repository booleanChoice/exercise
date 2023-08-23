/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import java.util.Arrays;

/**
 * @author booleanchoice
 * @version QuickSortExercise.java, v 0.1 2023年08月23日 11:22 booleanchoice
 */
public class QuickSortExercise {

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 2, 2, 6, 1, 2, 5, 4,7, 8 ,1 , 2000};
        quickSort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }


    public static void quickSort(int[] a, int left, int right) {

        // 递归出口
        if (left < right) {
            // 基准
            // 此时坑为基准值x所在的位置，即最左面
            int x = a[left];
            // 左索引
            int i = left;
            // 右索引
            int j = right;

            // 开始多趟移位，直到i = j
            while (i < j) {
                // 从右向左找，找比基准小的位置
                while (i < j &&  a[j] >= x) {
                    j--;
                }
                // 找到了则把该数放到坑中，此时坑为j的位置，左索引右移
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }

                // 从左向右找，找比基准大的位置
                while (i < j &&  a[i] <= x) {
                    i++;
                }
                // 找到了则把该数放到坑中，此时坑为i的位置，右索引左移
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }

            // 此时i = j，把基准放到坑里
            a[i] = x;
            // 递归排序基准左右的两个区间
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

}