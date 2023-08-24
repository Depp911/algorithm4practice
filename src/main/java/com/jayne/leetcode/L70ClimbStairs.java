package com.jayne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L70ClimbStairs {

    public static void main(String[] args) {
//        System.out.println(climbStairsRecursion(40));
        System.out.println(climbStairsRecursionCache(40));
        System.out.println(climbStairs(40));
    }

    private static Map<Integer, Integer> cache = new HashMap<>();

    private static int climbStairsRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }
    private static int climbStairsRecursionCache(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = climbStairsRecursion(n -1) + climbStairsRecursion(n -2);
        cache.put(n, result);
        return result;
    }

    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 2;
        int prePre = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = prePre + pre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
