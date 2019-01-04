package com.jayne.book;

import com.jayne.util.*;

import java.io.File;

/**
 * 字符表的应用-文件索引
 *
 * Created by Jayne on 2018/12/28.
 */
public class FileIndex {

    public static void main(String[] args) {
        ST<String, SET<File>> index = new ST<>();

        for(String filename : args){
            File file = new File(filename);
            In in = new In(file);

            while (!in.isEmpty()){
                String key = in.readString();
                if(!index.contains(key)){
                    index.put(key, new SET<>());
                }
                index.get(key).add(file);
            }
        }

        while (!StdIn.isEmpty()){
            String query = StdIn.readLine();
            if(index.contains(query)){
                StdOut.println(query);
                for(File file : index.get(query)){
                    StdOut.println("    " + file.getName());
                }
            }
        }
    }
}
