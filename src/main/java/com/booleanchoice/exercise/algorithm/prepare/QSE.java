/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import java.util.Arrays;

/**
 * @author booleanchoice
 * @version QSE.java, v 0.1 2023年08月30日 17:53 booleanchoice
 */
public class QSE {

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 2, 2, 6, 1, 2, 5, 4,7, 8 ,1 , 2000};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = arr[l];

            while (i < j) {
                while (i < j && arr[j] > x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }

            arr[i] = x;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }

}