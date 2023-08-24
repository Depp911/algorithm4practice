package com.jayne.leetcode;

public class L5LongestPalindrome {

    public static void main(String[] args) {
        String test1 = "dbdbwbdbd";
        String test2 = "aaddfefedd";
        System.out.println(longestPalindrome(test1));
        System.out.println(longestPalindrome(test2));

        System.out.println(longestPalindrome2(test1));
        System.out.println(longestPalindrome2(test2));
    }

    private static String longestPalindrome(String source) {
        String result = null;
        int length = source.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String tmp = source.substring(i, j);
                if (isPalindrome(tmp) && tmp.length() > max) {
                    result = tmp;
                    max = tmp.length();
                }
            }
        }
        return result;
    }

    private static String longestPalindrome2(String source) {
        String result = null;
        int length = source.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + max + 1; j <= length; j++) {
                String tmp = source.substring(i, j);
                if (isPalindrome(tmp) && tmp.length() > max) {
                    result = tmp;
                    max = tmp.length();
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String source) {
        int length = source.length();
        for (int i = 0; i < length; i++) {
            if (source.charAt(i) != source.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
