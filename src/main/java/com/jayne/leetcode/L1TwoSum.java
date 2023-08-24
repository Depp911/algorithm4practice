package com.jayne.leetcode;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bin.chen
 * @create 2023-02-27 7:32 PM
 */
public class L1TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 18;
        System.out.println(JSONUtil.toJsonStr(own(nums, target)));
        System.out.println(JSONUtil.toJsonStr(twoSum(nums, target)));
    }

    public static int[] own(int[] source, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int x = source[i];
            int y = target - x;
            if (tmpMap.containsKey(y)) {
                return new int[] {tmpMap.get(y), i};
            }
            tmpMap.put(x, i);
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = MapUtil.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if (tmpMap.containsKey(y)) {
                return new int[] {tmpMap.get(y), i};
            }
            tmpMap.put(x, i);
        }
        return null;
    }
}
