package com.jayne.sort;

/**
 * 排序模板
 *
 * Created by Jayne on 2018/12/13.
 */
public abstract class BaseSort {

    public abstract void sort(Comparable[] array);

    protected boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    protected void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    protected void show(Comparable[] array){
        for(Comparable tmp : array){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    protected boolean isSorted(Comparable[] array){
        for(int i = 1; i < array.length; i++){
            if(less(array[i], array[i - 1])){
                return false;
            }
        }
        return true;
    }
}
