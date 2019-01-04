package com.jayne.book;

/**
 * 无序符号表基础类
 *
 * Created by Jayne on 2018/12/26.
 */
public abstract class SimpleSTInterface<Key, Value> {

    abstract void put(Key key, Value value);

    abstract Value get(Key key);

    public void delete(Key key){
        put(key, null);
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    abstract int size();

    abstract Iterable<Key> keys();
}
