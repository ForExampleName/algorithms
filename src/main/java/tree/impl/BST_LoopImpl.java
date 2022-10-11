package tree.impl;

import tree.Tree;

import java.util.LinkedList;

public class BST_LoopImpl<K extends Comparable<K>, V> implements Tree<K, V> {
    private Node root;

    @Override
    public V get(K key) {
        Node node = getNodeByKey(key);
        return node == null ? null : node.value;
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }

        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;

        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                parent = current;
                current = current.left;
            } else if (cmp > 0) {
                parent = current;
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }

        current = new Node(key, value);
        if (current.key.compareTo(parent.key) < 0) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        current = root;
        while (true) {
            ++current.size;
            int cmp = parent.key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }
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
        Node node = getNodeByKey(key);
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
        if (root == null) {
            return 0;
        }

        LinkedList<Node> elements = new LinkedList<>();
        elements.add(root);

        int height = 1;
        while (!elements.isEmpty()) {
            int currentLevelItemCount = elements.size();
            for (int i = 0; i < currentLevelItemCount; i++) {
                Node current = elements.removeFirst();
                if (current.left != null) {
                    elements.add(current.left);
                }

                if (current.right != null) {
                    elements.add(current.right);
                }
            }

            if (!elements.isEmpty()) {
                ++height;
            }
        }

        return height;
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print("(K: " + node.key + "; V: " + node.value + ") ");
        print(node.right);
    }

    private Node getNodeByKey(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
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
