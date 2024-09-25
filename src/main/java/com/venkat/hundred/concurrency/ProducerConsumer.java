package com.venkat.hundred.concurrency;

import java.util.LinkedList;
import java.util.Queue;
/*
1. Producer-Consumer Problem using Threads
The Producer-Consumer Problem is a classic example of multithreading where the producer generates data, and the consumer processes it.
 */
class ProducerConsumer {

    private static final int CAPACITY = 5; // Capacity of the shared buffer
    private final Queue<Integer> queue = new LinkedList<>(); // Shared buffer
    private int value = 0; // Value to produce

    // Producer thread
    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (queue) {
                        while (queue.size() == CAPACITY) {
                            queue.wait(); // Wait until the queue has space
                        }
                        System.out.println("Produced: " + value);
                        queue.add(value++); // Produce and add to the queue
                        queue.notifyAll(); // Notify consumer threads
                    }
                    Thread.sleep(1000); // Simulate time-consuming production
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Consumer thread
    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            queue.wait(); // Wait until the queue has items
                        }
                        int consumedValue = queue.poll(); // Consume an item from the queue
                        System.out.println("Consumed: " + consumedValue);
                        queue.notifyAll(); // Notify producer threads
                    }
                    Thread.sleep(1500); // Simulate time-consuming consumption
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producer = new Thread(pc.new Producer());
        Thread consumer = new Thread(pc.new Consumer());

        producer.start();
        consumer.start();
    }
}

