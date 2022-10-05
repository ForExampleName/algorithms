package queue;

import queue.impl.Ring;

import java.util.Iterator;

public class Main {
    private <T>void printQueue(Queue<T> queue) {
        System.out.println("----------------------------------------------");
        if(queue.isEmpty()) {
            System.out.println("Queue is empty...");
            return;
        }

        System.out.println("Queue size: " + queue.size());

        Iterator<T> iterator = queue.iterator();
        System.out.println("HEAD");
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println("TAIL");
    }

    public static void main(String... args) {
        Main main = new Main();

        Queue<Integer> queue = new Ring<>();
        main.printQueue(queue);

        queue.push(12);
        queue.push(15);
        queue.push(18);
        queue.push(5);

        main.printQueue(queue);

        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        queue.push(7);

        main.printQueue(queue);
    }
}
