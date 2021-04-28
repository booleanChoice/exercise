/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm;



/**
 * leetcode 4
 *
 * 给定两个大小为 m 和 n 的*有序*数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */

/**
 *
 * @author booleanchoice
 * @version $Id: FindMedianSortedArrays.java, v 0.1 2018年12月24日 3:05 PM booleanchoice Exp $
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 特殊处理
        if (length1 == 0 && length2 == 0) {
            return -1;
        }
        if (length1 == 0 && length2 != 0) {
            return findMedianInOneSortedArray(nums2);
        }
        if (length2 == 0 && length1 != 0) {
            return findMedianInOneSortedArray(nums1);
        }
        // merge操作
        int[] mergedSortedNums = new int[length1 + length2];
        int i = 0, j = 0;
        int r = 0;
        while (i <= length1 - 1 && j <= length2 -1) {
            if (nums1[i] < nums2[j]) {
                mergedSortedNums[r++] = nums1[i++];
            } else {
                mergedSortedNums[r++] = nums2[j++];
            }
        }
        for (; i <= length1 - 1; i++) {
            mergedSortedNums[r++] = nums1[i];
        }
        for (; j <= length2 - 1; j++) {
            mergedSortedNums[r++] = nums2[j];
        }
        return findMedianInOneSortedArray(mergedSortedNums);
    }

    private static double findMedianInOneSortedArray(int[] nums) {
        int length = nums.length;
        if (length != 0) {
            if (length % 2 != 0) {
                return nums[(length - 1) >> 1];
            } else {
                int a = (length - 1) >> 1;
                return ((nums[(length - 1) >> 1] + nums[((length - 1) >> 1) + 1]) * 1.0D) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4};
        System.out.println("两个排序数组的中位数为：" + findMedianSortedArrays(nums1, nums2));
    }

}