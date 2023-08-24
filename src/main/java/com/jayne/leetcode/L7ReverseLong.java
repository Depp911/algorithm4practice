package com.jayne.leetcode;

/**
 * @author bin.chen
 * @create 2023-03-14 4:16 PM
 */
public class L7ReverseLong {

    public static void main(String[] args) {
        int x = -1230;
        System.out.println(reverse(x));
        System.out.println(own(x));
        System.out.println(reverse2(x));
    }

    private static int own(int source) {
        int result = 0;
        while (source != 0) {
            int tmp = source % 10;
            result = result * 10 + tmp;
            source = source / 10;
        }
        return result;
    }

    private static int reverse2(int x) {
        String xString = Integer.toString(x);
        String tmp = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            tmp = xString.substring(1);
        }
        try {
            return Integer.valueOf(new StringBuilder(tmp).reverse().toString()) * flag;
        }catch (Exception e) {
            return 0;
        }
    }

    private static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int) result;
    }
}
