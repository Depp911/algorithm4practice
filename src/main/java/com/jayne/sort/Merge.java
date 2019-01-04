package com.jayne.sort;

/**
 * 自顶向下的归并排序
 *
 * Created by Jayne on 2018/12/14.
 */
public class Merge extends BaseMerge {

    public void sort(Comparable[] array) {
        tmp = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] array, int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        merge.sort(array);
        merge.show(array);
    }
}
