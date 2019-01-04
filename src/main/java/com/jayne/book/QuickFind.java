package com.jayne.book;

/**
 * quick-find算法实现
 *
 * Created by Jayne on 2018/12/12.
 */
public class QuickFind extends UnionFindBase {

    public QuickFind(int n){
        super(n);
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if(pID == qID){
            return;
        }

        for(int i = 0; i < id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }
}
