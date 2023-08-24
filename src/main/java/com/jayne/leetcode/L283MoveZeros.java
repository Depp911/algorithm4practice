package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

public class L283MoveZeros {

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};
        moveZeroes(nums1);
        moveZeroes(nums2);
        System.out.println(JSONUtil.toJsonStr(nums1));
        System.out.println(JSONUtil.toJsonStr(nums2));
    }

    private static void moveZeroes(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                nums[index++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
