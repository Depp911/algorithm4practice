package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.IndexMinPQ;
import com.jayne.util.StdOut;

/**
 * 多向归并：将多个有序的输入流归并成一个有序的输出流
 *
 * 使用优先队列实现多向归并
 *
 * Created by Jayne on 2018/12/23.
 */
public class Multiway {

    public static void merge(In[] streams){
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);
        for(int i = 0; i < N; i++){
            if(!streams[i].isEmpty()){
                pq.insert(i, streams[i].readString());
            }
        }

        while (!pq.isEmpty()){
            StdOut.println(pq.minKey());
            int i = pq.delMin();
            if(!streams[i].isEmpty()){
                pq.insert(i, streams[i].readString());
            }
        }
    }

    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for(int i = 0; i < N; i++){
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}
