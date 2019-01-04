package com.jayne.book;

/**
 * 基于链表的无序符号表的实现
 *
 * Created by Jayne on 2018/12/26.
 */
public class SequentialSearchST<Key, Value> extends SimpleSTInterface<Key, Value> {

    private int N;
    private Node first;

    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    void put(Key key, Value value) {
        for(Node node = first; node != null; node = node.next){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    @Override
    Value get(Key key) {
        for(Node node = first; node != null; node = node.next){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }

    @Override
    int size() {
        return N;
    }

    @Override
    Iterable keys() {
        Queue<Key> queue = new Queue<>();
        for(Node node = first; node != null; node = node.next){
            queue.enqueue(node.key);
        }
        return queue;
    }

    @Override
    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node node, Key key){
        if (node == null){
            return null;
        }
        if(key.equals(node.key)){
            N--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }
}
