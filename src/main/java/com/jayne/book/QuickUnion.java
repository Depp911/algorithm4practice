package com.jayne.book;

/**
 * quick-union算法实现
 *
 * Created by Jayne on 2018/12/12.
 */
public class QuickUnion extends UnionFindBase {

    public QuickUnion(int n){
        super(n);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public int find(int p) {
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }
}
