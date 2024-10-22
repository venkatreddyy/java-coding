package com.venkat.challenges.top15;

import java.util.LinkedList;

public class ProducerConsumer {

    public static class Buffer {
        private final int capacity = 5;
        private final LinkedList<Integer> list = new LinkedList<>();

        public synchronized void produce(int value) throws InterruptedException {
            while (list.size() == capacity) {
                wait(); // Wait if the buffer is full
            }
            list.add(value);
            System.out.println("Produced: " + value);
            notify(); // Notify the consumer thread
        }

        public synchronized void consume() throws InterruptedException {
            while (list.isEmpty()) {
                wait(); // Wait if the buffer is empty
            }
            int value = list.removeFirst();
            System.out.println("Consumed: " + value);
            notify(); // Notify the producer thread
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(100); // Simulate production time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.consume();
                    Thread.sleep(150); // Simulate consumption time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}

