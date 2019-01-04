package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.MinPQ;
import com.jayne.util.StdOut;
import com.jayne.util.Transaction;

/**
 * 利用优先队列实现从N个数中找出最大的M个
 *
 * Created by Jayne on 2018/12/22.
 */
public class TopM {

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        In in = new In("tinyBatch.txt");
        MinPQ<Transaction> minPQ = new MinPQ<>(M + 1);
        while (in.hasNextLine()){
            minPQ.insert(new Transaction(in.readLine()));
            if(minPQ.size() > M){
                minPQ.delMin();
            }
        }

        Stack<Transaction> stack = new Stack<>();
        while (!minPQ.isEmpty()){
            stack.push(minPQ.delMin());
        }
        for(Transaction transaction : stack){
            StdOut.println(transaction);
        }
    }
}
