package tree.impl;

import tree.Tree;

public class BST_RecursiveImpl<K extends Comparable<K>, V> implements Tree<K, V> {
    private Node root;

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    @Override
    public V get(K key) {
        Node node = getNodeByKey(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    @Override
    public int subtreeSize(K key) {
        Node node = getNodeByKey(root, key);
        return node == null ? 0 : node.size;
    }

    @Override
    public void print() {
        System.out.println("***********TREE***********");
        print(root);
        System.out.println();
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return (Math.max(leftHeight, rightHeight)) + 1;
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print("(K: " + node.key + "; V: " + node.value + ") ");
        print(node.right);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int result = key.compareTo(node.key);
        if (result < 0) {
            node.left = put(node.left, key, value);
            node.size = (node.right == null ? 0 : node.right.size) + node.left.size + 1;
        } else if (result > 0) {
            node.right = put(node.right, key, value);
            node.size = (node.left == null ? 0 : node.left.size) + node.right.size + 1;
        } else {
            node.value = value;
        }

        return node;
    }

    private Node getNodeByKey(Node node, K key) {
        if (node == null) {
            return null;
        }

        int result = key.compareTo(node.key);
        if (result < 0) {
            return getNodeByKey(node.left, key);
        } else if (result > 0) {
            return getNodeByKey(node.right, key);
        } else {
            return node;
        }
    }

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }
}
