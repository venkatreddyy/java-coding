package com.venkat.hundred.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
2. Deadlock Detection and Avoidance
Deadlock occurs when two or more threads are waiting for each other to release resources. This example demonstrates deadlock avoidance using tryLock():
 */
class DeadlockAvoidance {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        if (lock1.tryLock()) {
            try {
                System.out.println("Lock1 acquired by Method1");
                Thread.sleep(100); // Simulate work
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Lock2 acquired by Method1");
                    } finally {
                        lock2.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock1.unlock();
            }
        }
    }

    public void method2() {
        if (lock2.tryLock()) {
            try {
                System.out.println("Lock2 acquired by Method2");
                Thread.sleep(100); // Simulate work
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Lock1 acquired by Method2");
                    } finally {
                        lock1.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        DeadlockAvoidance da = new DeadlockAvoidance();
        Thread t1 = new Thread(da::method1);
        Thread t2 = new Thread(da::method2);

        t1.start();
        t2.start();
    }
}
