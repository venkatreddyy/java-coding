package com.venkat.programs.basic.misc;

public class VolatileExample {
    // Declare a volatile boolean flag
    private static volatile boolean running = true;

    public static void main(String[] args) {
        // Start a new thread that continuously checks the flag
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Worker thread started.");
                while (running) {
                    // Do some work (simulated with sleep)
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Worker thread interrupted.");
                    }
                }
                System.out.println("Worker thread stopped.");
            }
        });

        worker.start();

        // Simulate some main thread work
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the worker thread by setting the flag to false
        System.out.println("Main thread stopping worker thread...");
        running = false;
    }
}
/*
Explanation:
Volatile Flag (running):

The running flag is declared as volatile. This means that any changes to this variable are immediately visible to other threads. Without volatile, the worker thread may not see the update made by the main thread.
Worker Thread:

The worker thread runs in a loop as long as the running flag is true.
The loop checks the running flag continuously. If the flag changes to false, the worker thread exits the loop and stops.
Main Thread:

The main thread sleeps for 500 milliseconds to simulate some work.
After the sleep, the main thread sets the running flag to false to stop the worker thread.
Thread Communication:

Because the running flag is volatile, the worker thread sees the updated value (false) as soon as the main thread changes it.
The worker thread exits the loop and stops, printing "Worker thread stopped."
Output:
arduino
Copy code
Worker thread started.
Main thread stopping worker thread...
Worker thread stopped.
Why Use volatile?
Without the volatile keyword, the JVM might cache the running variable in the worker thread. This caching means the worker thread might not immediately see the update made by the main thread, causing it to continue running indefinitely or for an unpredictable amount of time. By using volatile, we ensure that the latest value of running is always visible to all threads, achieving predictable behavior.

When to Use volatile
Flag Variables: Use volatile for variables used as flags (like running) that indicate the state or should be immediately visible to multiple threads.
Simple Read/Write Operations: volatile is suitable when multiple threads are reading and writing to a single variable without additional complex operations. If you need more complex synchronization (like incrementing a counter), consider using synchronized blocks or Atomic classes.
Avoid Race Conditions: Helps avoid race conditions in cases where the check-then-act pattern is sufficient.
Limitations of volatile
No Atomicity: volatile does not guarantee atomicity. For example, incrementing a volatile int is not atomic (it involves reading, modifying, and writing).
No Mutual Exclusion: volatile does not provide mutual exclusion. If you need to ensure that only one thread executes a piece of code at a time, use synchronized.
volatile is a lightweight synchronization mechanism that is simpler and less costly than using locks (synchronized) but is only suitable for certain use cases.
 */

