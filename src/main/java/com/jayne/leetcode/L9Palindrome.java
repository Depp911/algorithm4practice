package com.jayne.leetcode;

/**
 * @author bin.chen
 * @create 2023-03-29 5:27 PM
 */
public class L9Palindrome {

    public static void main(String[] args) {
        int source1 = 22332;
        int source2 = 34543;
        System.out.println(isPalindrome(source1));
        System.out.println(isPalindrome2(source1));
        System.out.println(isPalindrome2(source2));
    }

    private static boolean isPalindrome(int source) {
        if (source < 0) {
            return false;
        }
        int y = 0;
        int tmp = source;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return y == source;
    }

    private static boolean isPalindrome2(int source) {
        String tmp = String.valueOf(source);
        int length = tmp.length();
        for (int i = 0; i < length; i++) {
            if (tmp.charAt(i) != tmp.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
