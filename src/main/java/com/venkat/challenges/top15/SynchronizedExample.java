package com.venkat.challenges.top15;

public class SynchronizedExample {

    public synchronized void displayMessage(String message) {
        System.out.print("[");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message + "]");
    }

    public static void main(String[] args) {
        SynchronizedExample syncExample = new SynchronizedExample();

        // Thread 1
        new Thread(() -> syncExample.displayMessage("Thread 1")).start();

        // Thread 2
        new Thread(() -> syncExample.displayMessage("Thread 2")).start();
    }
}

