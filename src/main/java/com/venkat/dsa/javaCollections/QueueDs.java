package com.venkat.dsa.javaCollections;

import java.util.*;

public class QueueDs {
    public static void main(String[] args) {
        Queue<Double> queue= new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(2.0);
        queue.offer(1.0);
        queue.offer(4.0);
        queue.offer(5.0);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
