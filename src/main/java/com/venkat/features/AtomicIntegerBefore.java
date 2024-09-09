package com.venkat.features;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

//Before Java 8 (Manual Synchronization):
public class AtomicIntegerBefore {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Creating 1000 threads to increment the counter
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        // Waiting for all threads to complete
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Final count: " + counter.getCount());
    }
}
