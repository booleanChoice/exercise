package com.booleanchoice.exercise.sort;

/**
 * @author liujianzhao
 *
 * 冒泡排序，一趟排序中，比较相邻两数，把大（或小）的数互换，
 * 并接着比较下一相邻的数，类似气泡浮出水面，故称作冒泡排序。
 */
public class BubbleSort {

    public static void bubbleSort(int[] s) {
        // 排序趟数迭代
        for (int i = 0; i < s.length - 1; i++) {
            // 每趟的比较迭代
            for (int j = 0; j < s.length - 1 - i; j++) {
                if (s[j] > s[j + 1]) {
                    int temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 6, 1, 2, 5};
        bubbleSort(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "　");
        }
    }

}
