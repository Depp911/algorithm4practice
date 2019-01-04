package com.jayne.util;

import java.util.concurrent.TimeUnit;

/**
 * 计时器
 *
 * Created by Jayne on 2018/12/11.
 */
public class Stopwatch {

    private final long start;

    public Stopwatch(){
        this.start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }

    public static void main(String[] args) throws Exception{
        Stopwatch timer = new Stopwatch();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(timer.elapsedTime());
    }
}
