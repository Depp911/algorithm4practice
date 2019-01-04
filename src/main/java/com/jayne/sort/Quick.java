package com.jayne.sort;

/**
 * 快速排序
 *
 * Created by Jayne on 2018/12/14.
 */
public class Quick extends BaseQuick {

    int partition(Comparable[] array, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = array[low];
        while (true){
            while (less(array[++i], v)){
                if(i == high){
                    break;
                }
            }
            while (less(v, array[--j])){
                if(j == low){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(array, i, j);
        }
        exch(array, low, j);
        return j;
    }

    public static void main(String[] args) {
        Quick quick = new Quick();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        quick.sort(array);
        quick.show(array);
    }
}
