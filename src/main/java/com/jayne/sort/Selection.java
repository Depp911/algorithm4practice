package com.jayne.sort;

/**
 * 选择排序
 *
 * Created by Jayne on 2018/12/13.
 */
public class Selection extends BaseSort {

    public void sort(Comparable[] array) {
        for(int i = 0; i < array.length; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if(less(array[j], array[min])){
                    min = j;
                }
            }
            exch(array, i, min);
        }
    }

    public static void main(String[] args) {
        Selection selection = new Selection();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        selection.sort(array);
        selection.show(array);
    }
}
