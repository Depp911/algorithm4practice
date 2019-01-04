package com.jayne.book;

/**
 * 加权quick-union算法实现
 *
 * Created by Jayne on 2018/12/12.
 */
public class WeightedQuickUnion extends UnionFindBase {

    int[] sz;

    public WeightedQuickUnion(int n){
        super(n);
        sz = new int[n];
        for(int i = 0; i < n; i++){
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        if(sz[p] > sz[q]){
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }

    public int find(int p) {
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }
}
