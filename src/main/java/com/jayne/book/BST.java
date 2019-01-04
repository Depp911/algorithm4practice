package com.jayne.book;

/**
 * 基于二分查找树的符号表
 *
 * Created by Jayne on 2018/12/27.
 */
public class BST<Key extends Comparable<Key>, Value> extends SortSTInterface<Key, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    @Override
    void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value){
        if(node == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return put(node.left, key, value);
        }else if (cmp > 0){
            return put(node.right, key, value);
        }else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return get(node.left, key);
        }else if(cmp > 0){
            return get(node.right, key);
        }else {
            return node.value;
        }
    }

    @Override
    void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key){
        if(node == null){
            return node;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = delete(node.left, key);
        }else if(cmp > 0){
            node.right = delete(node.right, key);
        }else {
            if(node.right == null){
                return node.left;
            }
            if (node.left == null){
                return node.right;
            }
            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node){
        if(node.right == null){
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    int size() {
        return size(root);
    }

    private int size(Node node){
        if(node == null){
            return 0;
        }else {
            return node.N;
        }
    }

    @Override
    Key min() {
        return min(root).key;
    }

    private Node min(Node node){
        if(node.left == null){
            return node;
        }else {
            return min(node.left);
        }
    }

    @Override
    Key max() {
        return max(root).key;
    }

    private Node max(Node node){
        if(node.right == null){
            return node;
        }else {
            return max(node.right);
        }
    }

    @Override
    Key floor(Key key) {
        Node node = floor(root, key);
        if(node == null){
            return null;
        }
        return node.key;
    }

    private Node floor(Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node;
        }
        if(cmp < 0){
            return floor(node.left, key);
        }
        Node t = floor(node.right, key);
        if(t != null){
            return t;
        }else {
            return node;
        }
    }

    @Override
    Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if(node == null){
            return null;
        }
        return node.key;
    }

    private Node ceiling(Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node;
        }
        if(cmp > 0){
            return ceiling(node.right, key);
        }
        Node t = ceiling(node.left, key);
        if(t != null){
            return t;
        }else {
            return node;
        }
    }

    @Override
    int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node){
        if(node == null){
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return rank(key, node.left);
        }else if(cmp > 0){
            return 1 + size(node.left) + rank(key, node.right);
        }else {
            return size(node.left);
        }
    }

    @Override
    Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k){
        if(node == null){
            return null;
        }
        int t = size(node.left);
        if(t > k){
            return select(node.left, k);
        }else if(t < k){
            return select(node.right, k);
        }else {
            return node;
        }
    }

    @Override
    Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key low, Key high){
        if(node == null){
            return;
        }
        int cmplow = low.compareTo(node.key);
        int cmphigh = high.compareTo(node.key);
        if(cmplow < 0){
            keys(node.left, queue, low, high);
        }
        if(cmplow <= 0 && cmphigh >= 0){
            queue.enqueue(node.key);
        }
        if(cmphigh > 0){
            keys(node.right, queue, low, high);
        }
    }
}
