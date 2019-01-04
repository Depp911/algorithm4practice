package com.jayne.book;

import com.jayne.util.StdIn;
import com.jayne.util.StdOut;

/**
 * java Average
 * 从控制台接收参数（Ctrl + D 结束）
 *
 * java Average < data.txt
 * 从文件中获取数据
 *
 * java RandomSeq 1000 100 200 | java Average
 * 管道：将一个程序的输出重定向到另一个程序的输入
 *
 */
public class Average {

    private Average() { }

    /**
     * Ctrl + D 结束
     * @param args
     */
    public static void main(String[] args) { 
        int count = 0;       // number input values
        double sum = 0.0;    // sum of input values

        // read data and compute statistics
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }

        // compute the average
        double average = sum / count;

        // print results
        StdOut.println("Average is " + average);
    }
}
