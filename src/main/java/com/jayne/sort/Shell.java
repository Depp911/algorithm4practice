package com.jayne.sort;

/**
 * 希尔排序
 *
 * Created by Jayne on 2018/12/13.
 */
public class Shell extends BaseSort {

    public void sort(Comparable[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(array[j], array[j - h]); j -= h){
                    exch(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        shell.sort(array);
        shell.show(array);
    }
}
