package com.venkat.hundred.concurrency;
/*
8. Implement a Thread-safe Circular Buffer
A Circular Buffer or Ring Buffer is a data structure that uses a fixed-size buffer as if it were connected end-to-end.
 */
class CircularBuffer {

    private final int[] buffer;
    private int head = 0, tail = 0, count = 0, capacity;

    public CircularBuffer(int size) {
        buffer = new int[size];
        capacity = size;
    }

    // Add item to the buffer
    public synchronized void add(int item) throws InterruptedException {
        while (count == capacity) {
            wait(); // Wait until space is available
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        count++;
        notifyAll(); // Notify consumers
    }

    // Remove item from the buffer
    public synchronized int remove() throws InterruptedException {
        while (count == 0) {
            wait(); // Wait until items are available
        }
        int item = buffer[head];
        head = (head + 1) % capacity;
        count--;
        notifyAll(); // Notify producers
        return item;
    }

    public static void main(String[] args) throws InterruptedException {
        CircularBuffer cb = new CircularBuffer(3);

        // Producer
        new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    cb.add(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Consumed: " + cb.remove());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}

