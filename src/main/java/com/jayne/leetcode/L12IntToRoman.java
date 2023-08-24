package com.jayne.leetcode;

/**
 * @author bin.chen
 * @create 2023-04-03 3:32 PM
 */
public class L12IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1900));
        System.out.println(intToRoman2(1900));
    }

    private static String intToRoman(int source) {
        StringBuilder reuslt = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            while (source >= nums[i]) {
                reuslt.append(romans[i]);
                source = source - nums[i];
            }
            i++; //此处异常
        }
        return reuslt.toString();
    }

    private static String intToRoman2(int source) {
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            while (source >= ints[i]) {
                result.append(strs[i]);
                source = source - ints[i];
            }
        }
        return result.toString();
    }
}
