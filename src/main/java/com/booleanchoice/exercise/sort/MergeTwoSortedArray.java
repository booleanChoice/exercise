package com.booleanchoice.exercise.sort;

/**
 * @author liujianzhao
 *
 * 合并两个有序数组，采用归并排序中“治”的部分
 * 思路为先声明一个大的结果数组，然后循环比较两个数组，
 * 把较小的数依次放入结果数组中，放置过程中下标不断增加，
 * 等其中一个数组放置完毕时，
 */
public class MergeTwoSortedArray {

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        // 两个有序数组指针
        int i = 0, j = 0;
        // 临时数组指针
        int r = 0;
        // 比较并把较小的数放在结果数组里面，且指针不断右移
        while (i <= a.length - 1 && j <= b.length - 1) {
            if (a[i] < b[j]) {
                result[r] = a[i];
                r++;
                i++;
            } else {
                result[r] = b[j];
                r++;
                j++;
            }
        }
        // 如果a数组还剩数字，则拷贝到结果数组后面
        while (i <= a.length - 1) {
            result[r] = a[i];
            r++;
            i++;
        }
        // 如果b数组还剩数字，则拷贝到结果数组后面
        while (j <= b.length - 1) {
            result[r] = b[j];
            r++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 8};
        int[] b = new int[]{7, 9};
        int[] result = merge(a, b);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + "　");
        }
    }
}
