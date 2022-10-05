package queue;

public interface Queue<T> extends Iterable<T> {
    boolean isEmpty();

    int size();

    void push(T item);

    T pop();
}
