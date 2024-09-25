package com.venkat.hundred.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
6. Dining Philosophers Problem using Threads
The Dining Philosophers Problem is a classic synchronization problem. It can be solved using locks to avoid deadlock.
 */
class DiningPhilosophers {

    private static final int NUM_PHILOSOPHERS = 5;
    private final Lock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];

    public DiningPhilosophers() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void dine(int philosopher) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % NUM_PHILOSOPHERS;

        // Pick up the forks
        forks[leftFork].lock();
        forks[rightFork].lock();

        // Eating
        System.out.println("Philosopher " + philosopher + " is eating.");

        // Put down the forks
        forks[leftFork].unlock();
        forks[rightFork].unlock();
    }

    public static void main(String[] args) {
        DiningPhilosophers dp = new DiningPhilosophers();

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            int philosopher = i;
            new Thread(() -> {
                try {
                    dp.dine(philosopher);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}

