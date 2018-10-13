package com.booleanchoice.exercise.sort;

/**
 * 归并排序，体现了分治法的思想：即分而治之，
 * 把一个大问题分解成若干个小问题，分别求解再整合到一起。
 * 具体操作为先把待排序数组从中间分成多个小数组，即“分”，本例采用递归，
 * 再通过小数组的排序，确定两个指针，把较小的数取出来放进临时数组中，使之有序，即“治”。
 */
public class MergeSort {


    public static void mergeSort(int[] a) {
        // 先声明一个大小够用的临时数组，避免之后开辟空间
        int[] tmp = new int[a.length];

        mergeSort(a, 0, a.length - 1, tmp);
    }

    /**
     *
     * @param a 待排序数组
     * @param l 左指针
     * @param r 右指针
     * @param tmp 临时数组
     */
    public static void mergeSort(int[] a, int l, int r, int[] tmp) {
        if(l < r) {
            // 此处递归求解，即“分”
            int mid = (l + r) / 2;
            mergeSort(a, l, mid, tmp);
            mergeSort(a, mid + 1, r, tmp);
            merge(a, l, mid, r, tmp);
        }
    }

    public static void merge(int[] a, int l, int mid, int r, int[] tmp) {
        int i = l, j = mid + 1;
        // 临时数组指针
        int t = 0;
        // 把较小的数放进临时数组中
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = a[j++];
            }
        }
        // 剩下的有序的数，直接复制进临时数组中
        while (i <= mid) {
            tmp[t++] = a[i++];
        }
        while (j <= r) {
            tmp[t++] = a[j++];
        }
        t = 0;
        // 把临时数组中排好序的数放进原数组
        while (l <= r) {
            a[l++] = tmp[t++];
        }
    }



    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 6, 1, 2, 5, 9, 8};
        mergeSort(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "　");
        }
    }
}