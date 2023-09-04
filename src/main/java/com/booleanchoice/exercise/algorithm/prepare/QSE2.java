/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import java.util.Arrays;

/**
 * @author booleanchoice
 * @version QSE2.java, v 0.1 2023年09月04日 19:06 booleanchoice
 */
public class QSE2 {

    public static void main(String[] args) {
//        int[] arr = new int[] {7, 1, 2, 3,2, 0, 9, 2000, 0,2001, 7, 1888, 1, 6};
        int[] arr = new int[]{1, 2, 3, 4,5 , 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int x = arr[left];
            int i = left;
            int j = right;

            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] <= x) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }

            arr[i] = x;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

}