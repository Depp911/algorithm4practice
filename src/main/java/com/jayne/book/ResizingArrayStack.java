package com.jayne.book;

import java.util.Iterator;

/**
 * 使用数据实现Stack
 * 特点：1，长度自动调整 2，泛型，可存储任意类型
 *
 * Created by Jayne on 2018/12/19.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public ResizingArrayStack(){
        a = (Item[]) new Object[1];
    }

    public ResizingArrayStack(int cap){
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){
        return 0 == N;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        if(N == a.length){
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        if(N > 0 && N <= a.length / 4){
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int cap){
        Item[] tmp = (Item[]) new Object[cap];
        for(int i = 0; i < N; i++){
            tmp[i] = a[i];
        }
        a = tmp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            return a[--i];
        }
    }
}
