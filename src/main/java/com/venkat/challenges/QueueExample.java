package com.venkat.challenges;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Mango");
        System.out.println(queue.poll()); // Apple (FIFO)
        System.out.println(queue); // [Banana, Mango]

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(20);
        System.out.println(priorityQueue.poll()); // 5 (Natural order)
        System.out.println(priorityQueue); // [10, 20]
    }
}

