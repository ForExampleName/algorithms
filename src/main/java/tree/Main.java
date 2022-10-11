package tree;

import tree.impl.BST_LoopImpl;

public class Main {
    public static void main(String... args) {
        Tree<Integer, String> tree = new BST_LoopImpl<>();
        tree.put(2, "TWO");
        tree.put(3, "THREE");
        tree.put(1, "ONE");
        tree.put(7, "SEVEN");
        tree.put(0, "ZERO");
        tree.put(5, "FIVE");
        tree.put(4, "FOUR");
        tree.put(6, "SIX");
        tree.put(6, "SIX");
        tree.put(7, "SEVEN");
        tree.put(7, "SEVEN");
        System.out.println("" + 2 + " " + tree.get(2));
        System.out.println("" + 3 + " " + tree.get(3));
        System.out.println("" + 1 + " " + tree.get(1));
        System.out.println("" + 7 + " " + tree.get(7));
        System.out.println("" + 0 + " " + tree.get(0));
        System.out.println("" + 5 + " " + tree.get(5));
        System.out.println("" + 4 + " " + tree.get(4));
        System.out.println("" + 6 + " " + tree.get(6));

        System.out.println(tree.subtreeSize(3));
        System.out.println(tree.subtreeSize(2));
        System.out.println(tree.subtreeSize(1));
        System.out.println(tree.subtreeSize(7));
        System.out.println(tree.subtreeSize(5));

        tree.print();

        System.out.println(tree.height());
    }
}
