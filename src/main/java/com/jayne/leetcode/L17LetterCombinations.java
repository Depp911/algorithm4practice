package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17LetterCombinations {

    public static void main(String[] args) {
        String source = "23";
        System.out.println(JSONUtil.toJsonStr(letterCombinations(source)));
    }

    private static List<String> letterCombinations(String source) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < source.length(); i++) {
            String value = map.get(String.valueOf(source.charAt(i)));
            List<String> t = new ArrayList<>();
            for (String exist : result) {
                for (String cha : value.split("")) {
                    t.add(exist + cha);
                }
            }
            result = t;
        }
        return result;
    }
}
