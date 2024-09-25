package com.venkat.hundred.concurrency;

import java.util.LinkedList;
import java.util.Queue;
/*
4. Implement a Thread-safe Blocking Queue
A Blocking Queue allows threads to wait until space is available to enqueue or until items are available to dequeue.
 */
class BlockingQueue<T> {

    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // Enqueue an item into the queue
    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if the queue is full
        }
        queue.add(item);
        notifyAll(); // Notify consumers
    }

    // Dequeue an item from the queue
    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the queue is empty
        }
        T item = queue.poll();
        notifyAll(); // Notify producers
        return item;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(3);

        // Producer thread
        new Thread(() -> {
            try {
                int i = 0;
                while (true) {
                    blockingQueue.enqueue(i);
                    System.out.println("Produced: " + i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                while (true) {
                    int value = blockingQueue.dequeue();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}

