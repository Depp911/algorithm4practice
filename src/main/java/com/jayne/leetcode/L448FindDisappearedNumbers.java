package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

public class L448FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        int[] nums2 = {1,1};
        System.out.println(JSONUtil.toJsonStr(findDisappearedNumbers(nums1)));
        System.out.println(JSONUtil.toJsonStr(findDisappearedNumbers(nums2)));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        for (int num : nums) {
            int index = (num - 1) % length;
            nums[index] += length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= length) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
