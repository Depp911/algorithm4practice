package com.jayne.leetcode;

/**
 * @author bin.chen
 * @create 2023-04-03 2:37 PM
 */
public class L11MaxArea {

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
        System.out.println(maxArea2(heights));
    }

    private static int maxArea(int[] heights) {
        int result = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int tmp = Math.min(heights[i], heights[j]);
            result = Math.max(result, (j - i) * tmp);
            if (heights[i] < heights[j]) {
                i++;
            }else {
                j--;
            }
        }
        return result;
    }

    private static int maxArea2(int[] heights) {
        int result = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int tmp = Math.min(heights[i], heights[j]);
            result = Math.max(result, tmp * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            }else {
                j--;
            }
        }
        return result;
    }
}
