package com.jayne.book;

/**
 * union-find算法接口
 *
 * Created by Jayne on 2018/12/12.
 */
public interface UnionFindInterface {

    void union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();
}
