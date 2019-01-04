package com.jayne.book;

import com.jayne.util.StdOut;
import com.jayne.util.StdRandom;

/**
 * java RandomSeq 1000 100 200
 * 输出1000个 [100, 200) 的数到控制台
 *
 * java RandomSeq 1000 100 200 > data.txt
 * 输出1000个 [100, 200) 的数到文件
 *
 * java RandomSeq 1000 100 200 | java Average
 * 管道：将一个程序的输出重定向到另一个程序的输入
 *
 * Created by Jayne on 2018/12/18.
 */
public class RandomSeq {

    public static void main(String[] args) {
        if(args == null || args.length < 3){
            System.out.println("usage: java RandomSeq N low high");
            return;
        }
        int N = Integer.parseInt(args[0]);
        double low = Double.parseDouble(args[1]);
        double high = Double.parseDouble(args[2]);
        for(int i = 0; i < N; i++){
            double x = StdRandom.uniform(low, high);
            StdOut.printf("%.2f\n", x);
        }
    }
}
