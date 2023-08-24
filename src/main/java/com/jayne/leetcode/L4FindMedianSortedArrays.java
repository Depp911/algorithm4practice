package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

public class L4FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,3,4,7,8};
        int[] arr2 = {2,4,5,10};
        int[] arr11 = {};
        int[] arr22 = {};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    private static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergeArr = new int [m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        if (m == 0) {
            return findMedian(arr2);
        }
        if (n == 0) {
            return findMedian(arr1);
        }
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                mergeArr[k] = arr1[i];
                i++;
            }else {
                mergeArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            mergeArr[k] = arr1[i];
            i++;
        }
        while (j < n) {
            mergeArr[k] = arr2[j];
            j++;
        }
        System.out.println(JSONUtil.toJsonStr(mergeArr));
        return findMedian(mergeArr);
    }

    private static double findMedian(int[] arr) {
        int length = arr.length;
        if (length % 2 == 0) {
            return (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
        }
        return arr[length / 2];
    }
}
