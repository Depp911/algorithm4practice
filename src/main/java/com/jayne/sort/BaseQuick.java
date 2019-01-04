package com.jayne.sort;

import com.jayne.util.StdRandom;

/**
 * 快速排序模板
 *
 * Created by Jayne on 2018/12/14.
 */
public abstract class BaseQuick extends BaseSort {

    public void sort(Comparable[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    protected void sort(Comparable[] array, int low, int high){
        if(low >= high){
            return;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    abstract int partition(Comparable[] array, int low, int high);
}
