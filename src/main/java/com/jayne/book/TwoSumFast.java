package com.jayne.book;

import java.util.Arrays;

/**
 * 统计一个文件中所有和为0的二整数元组的数量
 *
 * Created by Jayne on 2018/12/21.
 */
public class TwoSumFast {

    public static int count(int[] array){
        int count = 0;
        Arrays.sort(array);
        int N = array.length;
        for(int i = 0; i < N; i++){
            if(BinarySearch.rank(-array[i], array) > i){
                count++;
            }
        }
        return count;
    }
}
