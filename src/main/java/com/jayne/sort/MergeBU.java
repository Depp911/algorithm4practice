package com.jayne.sort;

/**
 * 自底向上的归并排序
 *
 * Created by Jayne on 2018/12/14.
 */
public class MergeBU extends BaseMerge {

    public void sort(Comparable[] array) {
        tmp = new Comparable[array.length];
        for(int sz = 1; sz < array.length; sz += sz){
            for(int low = 0; low < array.length - sz; low += sz + sz){
                merge(array, low, low + sz -1, Math.min(low + sz + sz -1, array.length - 1));
            }
        }
    }

    public static void main(String[] args) {
        MergeBU mergeBU = new MergeBU();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        mergeBU.sort(array);
        mergeBU.show(array);
    }
}
