package com.venkat.features;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}

//After Java 8 (Using AtomicInteger):
public class AtomicIntegerAfter {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();

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
