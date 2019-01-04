package com.jayne.sort;

/**
 * 归并排序模板
 *
 * Created by Jayne on 2018/12/14.
 */
public abstract class BaseMerge extends BaseSort {

    protected Comparable[] tmp;

    public void merge(Comparable[] array, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            tmp[i] = array[i];
        }

        int j = low;
        int k = mid + 1;
        for(int i = low; i <= high; i++){
            if(j > mid){
                array[i] = tmp[k++];
            }else if(k > high){
                array[i] = tmp[j++];
            }else if(less(tmp[j], tmp[k])){
                array[i] = tmp[j++];
            }else {
                array[i] = tmp[k++];
            }
        }
    }
}
