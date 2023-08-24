package com.jayne.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L6NConvert {

    public static void main(String[] args) {
        String source = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(nConvert(source, numRows));
        System.out.println(nConvert(source, numRows).equals("PAHNAPLSIIGYIR"));
    }

    private static String nConvert(String source, int numRows) {
        if (source.length() <= numRows) {
            return source;
        }
        List<StringBuilder> rowBuilders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rowBuilders.add(new StringBuilder());
        }
        int direction = -1;
        int index = 0;
        for (int i = 0; i < source.length(); i++) {
            rowBuilders.get(index).append(source.charAt(i));
            if (index == 0 || index == numRows - 1) {
                direction = -direction;
            }
            index += 1 * direction;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : rowBuilders) {
//            System.out.println(builder);
            result.append(builder);
        }
        return result.toString();
    }
}
