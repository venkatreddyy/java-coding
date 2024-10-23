package com.venkat.challenges.top15;

import java.util.LinkedList;

public class ProducerConsumer {

    // Nested Buffer class to act as a shared resource between producer and consumer
    public static class Buffer {
        private final int capacity = 5; // The buffer's capacity is fixed at 5
        private final LinkedList<Integer> list = new LinkedList<>(); // LinkedList to store produced items

        // Synchronized method for the producer to add items to the buffer
        public synchronized void produce(int value) throws InterruptedException {
            // While the buffer is full (list size equals capacity), the producer must wait
            while (list.size() == capacity) {
                wait(); // The producer waits until space becomes available
            }

            // Add the produced value to the buffer (LinkedList)
            list.add(value);
            System.out.println("Produced: " + value); // Output produced value

            // Notify the consumer that the buffer is no longer empty
            notify(); // Wake up a waiting consumer thread, if any
        }

        // Synchronized method for the consumer to remove items from the buffer
        public synchronized void consume() throws InterruptedException {
            // While the buffer is empty, the consumer must wait
            while (list.isEmpty()) {
                wait(); // The consumer waits until there is something to consume
            }

            // Remove and consume the first item from the buffer
            int value = list.removeFirst();
            System.out.println("Consumed: " + value); // Output consumed value

            // Notify the producer that space is available in the buffer
            notify(); // Wake up a waiting producer thread, if any
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer(); // Create a shared buffer instance

        // Producer thread: simulates producing items
        Thread producer = new Thread(() -> {
            try {
                // Produce 10 items
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i); // Produce an item and add it to the buffer
                    Thread.sleep(100); // Simulate production time with a delay of 100ms
                }
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interruptions
            }
        });

        // Consumer thread: simulates consuming items
        Thread consumer = new Thread(() -> {
            try {
                // Consume 10 items
                for (int i = 0; i < 10; i++) {
                    buffer.consume(); // Consume an item from the buffer
                    Thread.sleep(150); // Simulate consumption time with a delay of 150ms
                }
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interruptions
            }
        });

        producer.start(); // Start the producer thread
        consumer.start(); // Start the consumer thread
    }
}


