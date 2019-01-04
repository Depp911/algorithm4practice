package com.jayne.book;

import java.util.Iterator;

/**
 * 使用链表实现Queue
 *
 * Created by Jayne on 2018/12/20.
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty(){
        return first == null; //ot N == 0
    }

    public int size(){
        return N;
    }

    //向链表尾部添加元素
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        //此处依赖isEmpty()的实现，若实现为N == 0, 则下面的N-- 需提前
        if(isEmpty()){
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Object next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
    }

    private class Node{
        private Item item;
        private Node next;
    }
}
