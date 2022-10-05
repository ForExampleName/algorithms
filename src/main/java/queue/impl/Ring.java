package queue.impl;

import queue.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ring<T> implements Queue<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(T item) {
        if(size == 0) {
            head = tail = new Node(item);
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
        tail.next = head;
        ++size;
    }

    @Override
    public T pop() {
        if(size == 0) {
            throw new NoSuchElementException("Очередь пустая...");
        }

        T value = head.value;
        head = head.next;
        tail.next = head;
        --size;
        return value;
    }

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public class CustomIterator implements Iterator<T> {
        private int itemsLeft = size;
        private Node current = head;

        @Override
        public boolean hasNext() {
            return itemsLeft > 0;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            --itemsLeft;
            return value;
        }
    }
}
