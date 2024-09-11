package com.venkat.dsa.datastructures;

/*
Enqueue: Adds an element to the rear of the queue, and the rear is updated using circular logic to wrap around the queue array.
Dequeue: Removes the front element and updates the front pointer using circular logic.
Peek: Retrieves the front element without removing it.
isEmpty: Returns true if the queue is empty.
isFull: Returns true if the queue is full.
 */
public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Enqueue method to add an element to the end of the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % maxSize; // Circular increment
            queueArray[rear] = value;
            currentSize++;
            System.out.println("Enqueued " + value + " to the queue.");
        }
    }

    // Dequeue method to remove the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return -1;
        } else {
            int dequeuedValue = queueArray[front];
            front = (front + 1) % maxSize; // Circular increment
            currentSize--;
            return dequeuedValue;
        }
    }

    // Peek method to view the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Main method to test the queue
    public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue of size 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element is: " + queue.peek()); // Output: 10

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 20

        queue.enqueue(60); // Adding a new element
        System.out.println("Front element is: " + queue.peek()); // Output: 30
    }
}

