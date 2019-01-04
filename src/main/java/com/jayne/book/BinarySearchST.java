package com.jayne.book;

/**
 * 基于二分查找的有序符号表的实现
 *
 * Created by Jayne on 2018/12/26.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> extends SortSTInterface<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    void put(Key key, Value value) {
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            values[i] = value;
            return;
        }
        for(int j = N; j > i; j--){
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    Value get(Key key) {
        if(isEmpty()){
            return null;
        }

        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return values[i];
        }else {
            return null;
        }
    }

    @Override
    void delete(Key key) {
        int i = rank(key);

        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N - 1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }

        N--;
        keys[N] = null;  // to avoid loitering
        values[N] = null;
    }

    @Override
    int size() {
        return N;
    }

    @Override
    Key min() {
        return keys[0];
    }

    @Override
    Key max() {
        return keys[N - 1];
    }

    @Override
    Key floor(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

    @Override
    Key ceiling(Key key) {
        int i = rank(key);
        if(i == N){
            return null;
        }
        return keys[i];
    }

    @Override
    int rank(Key key) {
        int low = 0, high = N - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0){
                high = mid - 1;
            }else if (cmp > 0){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return low;
    }

    @Override
    Key select(int k) {
        return keys[k];
    }

    @Override
    Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new Queue<>();
        for(int i = rank(low); i < rank(high); i++){
            queue.enqueue(keys[i]);
        }
        if(contains(high)){
            queue.enqueue(keys[rank(high)]);
        }
        return queue;
    }

}
