package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

public class L88MergeTwoArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge2(nums1, m, nums2, n);
        System.out.println(JSONUtil.toJsonStr(nums1));

        int[] nums11 = {1};
        int m1 = 1;
        int[] nums21 = {};
        int n1 = 0;
        merge2(nums11, m1, nums21, n1);
        System.out.println(JSONUtil.toJsonStr(nums11));

        int[] nums12 = {0};
        int m2 = 0;
        int[] nums22 = {1};
        int n2 = 1;
        merge2(nums12, m2, nums22, n2);
        System.out.println(JSONUtil.toJsonStr(nums12));
    }

    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n;
        int j = m;
        int k = n;
        for (;i > 0;) {
            if (j <= 0) {
                nums1[--i] = nums2[--k];
                continue;
            }
            if (k <= 0) {
                nums1[--i] = nums1[--j];
                continue;
            }
            if (nums1[j-1] > nums2[k-1]) {
                nums1[--i] = nums1[--j];
            }else {
                nums1[--i] = nums2[--k];
            }
        }
    }

    private static void mergeReverseOrder(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
//        Arrays.sort(nums1, Collections.reverseOrder());
    }
}
