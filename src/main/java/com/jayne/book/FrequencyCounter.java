package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.ST;
import com.jayne.util.StdOut;

/**
 * 字符表的应用示例
 *
 * Created by Jayne on 2018/12/26.
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        ST<String, Integer> st = new ST();
        int N = Integer.parseInt(args[0]);
        In in = new In(args[1]);
        while (!in.isEmpty()){
            String tmp = in.readString();
            if(tmp.length() < N){
                continue;
            }
            if(!st.contains(tmp)){
                st.put(tmp, 1);
            }else {
                st.put(tmp, st.get(tmp) + 1);
            }
        }
        String max = " ";
        int count = 0;
        for(String tmp : st.keys()){
            if(st.get(tmp) > count){
                max = tmp;
                count = st.get(tmp);
            }
        }

        StdOut.println("max: " + max + ", count: " + count);
    }
}
