/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import java.util.Arrays;

/**
 * @author booleanchoice
 * @version QuickSortExercise2.java, v 0.1 2023年09月05日 17:18 booleanchoice
 */
public class QuickSortExercise2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 2, 3, 6, 3, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int x = a[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && a[j] >= x) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] <= x) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
    }

}