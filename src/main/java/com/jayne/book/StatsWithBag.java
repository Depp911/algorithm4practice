package com.jayne.book;

import com.jayne.util.StdIn;
import com.jayne.util.StdOut;

/**
 * Bag 数据结构的使用案例
 *
 * Created by Jayne on 2018/12/19.
 */
public class StatsWithBag {

    public static void main(String[] args) {
        Bag<Double> doubleBag = new Bag<>();
        while (!StdIn.isEmpty()){
            doubleBag.push(StdIn.readDouble());
        }
        int N = doubleBag.size();
        if(N <= 1){
            return;
        }

        double sum = 0;
        for(double tmp : doubleBag){
            sum += tmp;
        }
        double mean = sum / N;

        sum = 0;
        for (double tmp : doubleBag){
            sum += (tmp - mean) * (tmp - mean);
        }
        //标准差 自由度 N - 1
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std: %.2f\n", std);
    }
}
