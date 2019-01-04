package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.StdOut;

import java.util.Arrays;

/**
 * 使用二分查找升级ThreeSum
 *
 * Created by Jayne on 2018/12/21.
 */
public class ThreeSumFast {

    public static int count(int[] array){
        int count = 0;
        Arrays.sort(array);
        int N = array.length;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(BinarySearch.rank(-array[i]-array[j], array) > j){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = In.readInts(args[0]);
        int count = ThreeSumFast.count(array);
        StdOut.println("size: " + array.length + ", count: " + count);
    }
}
