package com.venkat.hundred.concurrency;
/*
2. Using ExecutorService and PriorityBlockingQueue
For more deterministic behavior, especially when dealing with task execution based on priority, you can use a thread pool with a PriorityBlockingQueue. This ensures that tasks are executed strictly in the order of their priority.
Explanation:
PriorityBlockingQueue ensures that tasks are dequeued based on their priority.
In the compareTo() method, tasks with a higher priority are executed first.
The ThreadPoolExecutor will always execute the highest-priority task first.
 */
import java.util.concurrent.*;

class Task implements Runnable, Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println("Executing " + name + " with priority " + priority);
    }

    @Override
    public int compareTo(Task other) {
        // Higher priority tasks are "smaller" in terms of comparison (they run first)
        return Integer.compare(other.priority, this.priority);
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        // Create a PriorityBlockingQueue
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();

        // Create an ExecutorService that uses the PriorityBlockingQueue
        ExecutorService executor = new ThreadPoolExecutor(
                1, 1, 0L, null, queue
        );

        // Submit tasks to the executor
        executor.submit(new Task("Task A", 1));  // Low priority
        executor.submit(new Task("Task B", 5));  // Medium priority
        executor.submit(new Task("Task C", 10)); // High priority

        // Shutdown the executor
        executor.shutdown();
    }
}
