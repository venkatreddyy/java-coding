package com.venkat.challenges;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue: " + queue);  // Output: Queue: [1, 2, 3]
        System.out.println("Dequeued element: " + queue.poll());  // Output: 1
        System.out.println("Peek element: " + queue.peek());      // Output: 2
    }
}

