package com.jayne.leetcode;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bin.chen
 * @create 2023-03-03 11:10 AM
 */
public class L3LongestSubstring {

    public static void main(String[] args) {
        String source = "abcdbacbb";
        System.out.println(lengthOfLongestSubstring(source));
        System.out.println(own(source));
    }

    public static int own(String source) {
        Set<Character> tmpSet = new HashSet<>();
        int result = 0;
        int start = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            while (tmpSet.contains(c)) {
                tmpSet.remove(source.charAt(start++));
            }
            tmpSet.add(c);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String source) {
        Set<Character> ss = Sets.newHashSet();
        int i = 0;
        int result = 0;
        for (int j = 0; j < source.length(); j++) {
            char c = source.charAt(j);
            while (ss.contains(c)) {
                ss.remove(source.charAt(i++));
            }
            ss.add(c);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
