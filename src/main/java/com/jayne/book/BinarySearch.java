package com.jayne.book;

/**
 * 二分查找
 *
 * Created by Jayne on 2018/12/11.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,3,5,6,7,8,9,10};
        int index = rank(6, array);
        if(index < 0){
            System.out.println(index);
        }else {
            System.out.println(array[index]);
        }

        int index2 = rank2(13, array);
        if(index2 < 0){
            System.out.println(index2);
        }else {
            System.out.println(array[index2]);
        }
    }

    public static int rank(int key, int[] array){
        int low = 0;
        int high = array.length - 1;
        while (high >= low){
            int mid = low + (high - low) / 2;
            if(key > array[mid]){
                low = mid + 1;
            }else if(key < array[mid]){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     * @param key
     * @param array
     * @return
     */
    public static int rank2(int key, int[] array){
        return rankRecursion(key, array, 0, array.length - 1);
    }

    private static int rankRecursion(int key, int[] array, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(key > array[mid]){
            return rankRecursion(key, array, mid + 1, high);
        }else if(key < array[mid]){
            return rankRecursion(key, array, low, mid - 1);
        }else {
            return mid;
        }
    }
}
