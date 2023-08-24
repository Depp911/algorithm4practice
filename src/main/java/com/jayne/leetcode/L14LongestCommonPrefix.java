package com.jayne.leetcode;

public class L14LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr1 = {"flower","flow","flight"};
        String[] arr2 = {"dog","racecar","car"};
        String[] arr3 = {"dog","dog"};
        String[] arr4 = {"dog","do"};
        System.out.println(longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix(arr2));
        System.out.println(longestCommonPrefix(arr3));
        System.out.println(longestCommonPrefix(arr4));
    }

    private static String longestCommonPrefix(String[] arr) {
        int arrSize = arr.length;
        String first = arr[0];
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < arrSize; j++) {
                //注意 arr[j].length() <= i 而不是 arr[j].length() < i
                if (arr[j].length() <= i || first.charAt(i) != arr[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}
