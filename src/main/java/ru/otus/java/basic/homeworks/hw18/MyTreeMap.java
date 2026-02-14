package ru.otus.java.basic.homeworks.hw18;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }


    public int size() {
        return size(root);
    }


    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.size;
    }


    public boolean isEmpty() {
        return root == null;
    }


    private void checkKeyIsNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
    }


    public void put(Key key, Value value) {
        checkKeyIsNull(key);

        root = put(root, key, value);
    }


    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, value);

        } else if (cmp > 0) {
            node.right = put(node.right, key, value);

        } else {
            node.value = value;
        }

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }


    public Value get(Key key) {
        return get(root, key);
    }


    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return get(node.left, key);

        } else if (cmp > 0) {
            return get(node.right, key);
        }

        return node.value;
    }


    public boolean contains(Key key) {
        return get(key) != null;
    }


    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }

        return toString(node.left) + node.key + " = " + node.value + ", " + toString(node.right);
    }
}
