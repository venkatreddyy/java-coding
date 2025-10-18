package com.venkat.challenges.apple;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 🔹 isEmpty() before adding
        System.out.println("isEmpty before offer(): " + queue.isEmpty()); // true

        // 🔹 offer(E e)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("After offer(10, 20, 30): " + queue); // [10, 20, 30]

        // 🔹 peek()
        System.out.println("peek(): " + queue.peek()); // 10 (head of queue)
        System.out.println("After peek(): " + queue);  // [10, 20, 30] (unchanged)

        // 🔹 poll()
        int removed = queue.poll();
        System.out.println("poll(): " + removed);       // 10
        System.out.println("After poll(): " + queue);   // [20, 30]

        // 🔹 isEmpty() after operations
        System.out.println("isEmpty after poll(): " + queue.isEmpty()); // false
    }
}

