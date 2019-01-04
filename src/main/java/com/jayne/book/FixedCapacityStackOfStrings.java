package com.jayne.book;

/**
 * 使用数据实现简易Stack的实现
 *
 * 问题：1，定长 2，只能存储字符串
 *
 * Created by Jayne on 2018/12/19.
 */
public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }

    public void push(String item){
        a[N++] = item;
    }

    public String pop(){
        return a[--N];
    }

    public boolean isEmpty(){
        return 0 == N;
    }

    public int size(){
        return N;
    }
}
