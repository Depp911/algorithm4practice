package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.ST;
import com.jayne.util.StdIn;
import com.jayne.util.StdOut;

/**
 * 字符表的应用-索引及反向索引（一个键对应多个值）
 *
 * Created by Jayne on 2018/12/28.
 */
public class LookupIndex {

    public static void main(String[] args) {
        //数据库
        In in = new In(args[0]);
        String splitter = args[1];

        //索引
        ST<String, Queue<String>> st = new ST<>();
        //反向索引
        ST<String, Queue<String>> ts = new ST<>();

        while (in.hasNextLine()){
            String[] tokens = in.readLine().split(splitter);
            String key = tokens[0];
            for(int i = 1; i < tokens.length; i++){
                String value = tokens[i];
                if(!st.contains(key)){
                    st.put(key, new Queue<>());
                }
                if(!ts.contains(value)){
                    ts.put(value, new Queue<>());
                }
                st.get(key).enqueue(value);
                ts.get(value).enqueue(key);
            }
        }

        while (!StdIn.isEmpty()){
            String query = StdIn.readLine();
            if(ts.contains(query)){
                StdOut.println(query);
                for(String tmp : ts.get(query)){
                    StdOut.println("    " + tmp);
                }
            }
            if(st.contains(query)){
                StdOut.println(query);
                for(String tmp : st.get(query)){
                    StdOut.println("    " + tmp);
                }
            }
        }
    }
}
