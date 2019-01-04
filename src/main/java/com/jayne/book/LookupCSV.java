package com.jayne.book;

import com.jayne.util.In;
import com.jayne.util.ST;
import com.jayne.util.StdIn;
import com.jayne.util.StdOut;

/**
 * 字符表的应用：字典（一个键对应一个值）
 *
 * Created by Jayne on 2018/12/28.
 */
public class LookupCSV {

    public static void main(String[] args) {
        In in = new In(args[0]);
        int column1 = Integer.parseInt(args[1]);
        int column2 = Integer.parseInt(args[2]);

        ST<String, String> table = new ST<>();
        while (in.hasNextLine()){
            String[] tokens = in.readLine().split(",");
            table.put(tokens[column1], tokens[column2]);
        }

        while (!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(table.contains(query)){
                StdOut.println(query + ": " + table.get(query));
            }
        }
    }
}
