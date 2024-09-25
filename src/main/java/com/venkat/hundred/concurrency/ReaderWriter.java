package com.venkat.hundred.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
5. Reader-Writer Problem
The Reader-Writer Problem involves multiple reader and writer threads accessing shared data. We use ReentrantReadWriteLock to ensure readers can access data simultaneously but writers need exclusive access.
 */
class ReaderWriter {

    private int sharedData = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.readLock().lock(); // Acquire read lock
        try {
            System.out.println("Read: " + sharedData);
        } finally {
            lock.readLock().unlock(); // Release read lock
        }
    }

    public void write(int value) {
        lock.writeLock().lock(); // Acquire write lock
        try {
            sharedData = value;
            System.out.println("Wrote: " + sharedData);
        } finally {
            lock.writeLock().unlock(); // Release write lock
        }
    }

    public static void main(String[] args) {
        ReaderWriter rw = new ReaderWriter();

        // Reader threads
        Thread reader1 = new Thread(rw::read);
        Thread reader2 = new Thread(rw::read);

        // Writer thread
        Thread writer = new Thread(() -> rw.write(42));

        writer.start();
        reader1.start();
        reader2.start();
    }
}

