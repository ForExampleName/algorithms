package tree;

public interface Tree<K extends Comparable<K>, V> {
    void put(K key, V value);

    V get(K key);

    int size();

    int subtreeSize(K key);

    void print();

    int height();
}
