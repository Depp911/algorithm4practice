package com.jayne.book;

import java.util.Iterator;

/**
 * 使用链表实现Stack
 *
 * Created by Jayne on 2018/12/20.
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public boolean isEmpty(){
        return first == null; //or N == 0
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
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
