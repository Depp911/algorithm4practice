package com.jayne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L13RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

        System.out.println(romanToInt2("III"));
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));
        System.out.println(romanToInt2("I"));
    }

    private static int romanToInt(String source) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);
        if (source.length() == 1) {
            return romanMap.get(source);
        }
        if (source.length() == 2) {
            if (romanMap.containsKey(source)) {
                return romanMap.get(source);
            }
            return romanMap.get(String.valueOf(source.charAt(0))) + romanMap.get(String.valueOf(source.charAt(1)));
        }
        int result = 0;
        int index = 0;
        while (index < source.length()) {
            if (index == source.length() - 1 || !romanMap.containsKey(source.substring(index, index + 2))) {
                result += romanMap.get(String.valueOf(source.charAt(index)));
                index += 1;
            } else {
                result += romanMap.get(source.substring(index, index + 2));
                index += 2;
            }
        }
        return result;
    }

    private static int romanToInt2(String source) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("D", 500);
        romanMap.put("C", 100);
        romanMap.put("L", 50);
        romanMap.put("X", 10);
        romanMap.put("V", 5);
        romanMap.put("I", 1);

        int result = 0;
        int preNum = romanMap.get(String.valueOf(source.charAt(0)));
        for (int i=1; i < source.length(); i++) {
            int num = romanMap.get(String.valueOf(source.charAt(i)));
            if (preNum < num) {
                result -= preNum;
            }else {
                result += preNum;
            }
            preNum = num;
        }
        result += preNum;
        return result;
    }
}
