package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18FourSum {

    public static void main(String[] args) {
        int[] source1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(JSONUtil.toJsonPrettyStr(fourSum(source1, target1)));

        int[] source2 = {2,2,2,2,2};
        int target2 = 8;
        System.out.println(JSONUtil.toJsonPrettyStr(fourSum(source2, target2)));
    }

    private static List<List<Integer>> fourSum(int[] source, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = source.length;
        if (length < 4) {
            return result;
        }
        Arrays.sort(source);
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && source[i] == source[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && source[j] == source[j - 1]) {
                    continue;
                }
                int remain = target - source[i] - source[j];
                for (int k = j + 1, l = length - 1; k < l;) {
                    int twoSum = source[k] + source[l];
                    if (remain == twoSum) {
                        result.add(Arrays.asList(source[i], source[j], source[k], source[l]));
                        k++;
                        l--;
                    }else if (twoSum > remain) {
                        l--;
                    }else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
