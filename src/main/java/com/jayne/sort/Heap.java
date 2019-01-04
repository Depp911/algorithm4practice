package com.jayne.sort;

/**
 * 堆排序
 *
 * Created by Jayne on 2018/12/23.
 */
public class Heap {

    public void sort(Comparable[] array) {
        int n = array.length;
        for (int k = n/2; k >= 1; k--)
            //构造二叉堆
            sink(array, k, n);
        while (n > 1) {
            //下沉排序
            exch(array, 1, n--);
            sink(array, 1, n);
        }
    }

    private void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j+1)){
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    protected boolean less(Comparable[] a, int i, int j){
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
    }

    public void show(Comparable[] array){
        for(Comparable tmp : array){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        Character[] array = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        heap.sort(array);
        heap.show(array);
    }
}
