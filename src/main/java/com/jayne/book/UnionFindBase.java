package com.jayne.book;

/**
 * union-find基础类，部分实现接口
 *
 * Created by Jayne on 2018/12/12.
 */
public abstract class UnionFindBase implements UnionFindInterface{

    protected int count;
    protected int[] id;

    public UnionFindBase(int n){
        this.count = n;
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
