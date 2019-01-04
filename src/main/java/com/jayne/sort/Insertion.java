package com.jayne.sort;

/**
 * 插入排序
 *
 * Created by Jayne on 2018/12/13.
 */
public class Insertion extends BaseSort {

    public void sort(Comparable[] array) {
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(less(array[j], array[j - 1])){
                    exch(array, j - 1, j);
                }else {
                    break;
                }
            }
        }
    }

    public void sort2(Comparable[] array) {
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0 && less(array[j], array[j - 1]); j--){
                exch(array, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        insertion.sort(array);
        insertion.show(array);

        Character[] array2 = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        insertion.sort2(array2);
        insertion.show(array2);
    }
}
