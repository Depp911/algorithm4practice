package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.StdOut;

/**
 * 统计一个文件中所有和为0的三整数元组的数量
 *
 * Created by Jayne on 2018/12/21.
 */
public class ThreeSum {

    public static int count(int[] array){
        int count = 0;
        int N = array.length;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                for (int k = j + 1; k < N; k++){
                    if(array[i] + array[j] + array[k] == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = In.readInts(args[0]);
        int count = ThreeSum.count(array);
        StdOut.println("size: " + array.length + ", count: " + count);
    }
}
