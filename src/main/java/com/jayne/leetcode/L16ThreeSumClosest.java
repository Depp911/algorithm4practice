package com.jayne.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class L16ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        int[] nums2 = {0, 0, 0};
        System.out.println(threeSumClosest(nums, target));
        System.out.println(threeSumClosest(nums2, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        Integer result = null;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1, k = length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                int div = target - sum;
                if (div > 0) {
                    j++;
                } else {
                    k--;
                }
                if (Objects.isNull(result)) {
                    result = sum;
                    continue;
                }
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
