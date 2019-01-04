package com.jayne.util;

/**
 * Created by Jayne on 2018/12/18.
 */
public class Counter {

    private final String name;
    private int count;

    public Counter(String id){
        name = id;
    }

    public void increment(){
        count++;
    }

    public int tally(){
        return count;
    }

    @Override
    public String toString() {
        return count + " " + name;
    }
}
