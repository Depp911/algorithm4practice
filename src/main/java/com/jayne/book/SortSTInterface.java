package com.jayne.book;

/**
 * 有序符号表的基础类
 *
 * Created by Jayne on 2018/12/26.
 */
public abstract class SortSTInterface<Key extends Comparable<Key>, Value> {
    abstract void put(Key key, Value value);

    abstract Value get(Key key);

    abstract void delete(Key key);

    public boolean contains(Key key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    abstract int size();

    abstract Key min();

    abstract Key max();

    abstract Key floor(Key key);

    abstract Key ceiling(Key key);

    abstract int rank(Key key);

    abstract Key select(int k);

    public void deleteMin(){
        delete(min());
    }

    public void deleteMax(){
        delete(max());
    }

    public int size(Key low, Key high){
        if(high.compareTo(low) < 0){
            return 0;
        }else if(contains(high)){
            return rank(high) - rank(low) + 1;
        }else {
            return rank(high) - rank(low);
        }
    }

    abstract Iterable<Key> keys(Key low, Key high);

    public Iterable<Key> keys(){
        return keys(min(), max());
    }
}
