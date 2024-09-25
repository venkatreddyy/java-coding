package com.venkat.hundred.concurrency;

/*
3. Implement a Thread-safe Singleton Pattern
A Thread-safe Singleton ensures that only one instance of a class is created in a multithreaded environment.
 */
class ThreadSafeSingleton {

    // Volatile keyword ensures visibility of changes to variables across threads
    private static volatile ThreadSafeSingleton instance;

    // Private constructor prevents instantiation from other classes
    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) { // Synchronized block for thread safety
                if (instance == null) { // Double-checked locking
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Thread-safe Singleton Instance");
    }

    public static void main(String[] args) {
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        singleton.showMessage();
    }
}

