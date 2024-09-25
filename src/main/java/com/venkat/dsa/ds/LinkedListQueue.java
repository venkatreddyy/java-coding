package com.venkat.dsa.ds;
/*
Advantages of Linked List Queue:
Dynamic Size: Unlike array-based queues, linked list queues grow dynamically as needed.
Memory Efficient: Only allocates memory for the elements present in the queue.
 */
public class LinkedListQueue {
    Node front, rear;

    // Node class for the linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode; // If queue is empty, both front and rear are the new node
            System.out.println("Enqueued " + value + " to the queue.");
            return;
        }

        rear.next = newNode; // Add the new node at the end of the queue
        rear = newNode; // Rear now becomes the new node
        System.out.println("Enqueued " + value + " to the queue.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return -1;
        }

        int dequeuedValue = front.data;
        front = front.next; // Move front to the next node
        if (front == null) { // If the queue becomes empty after dequeue
            rear = null;
        }
        return dequeuedValue;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (front == null);
    }

    // Main method to test the linked list queue
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element is: " + queue.peek()); // Output: 10

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 20

        queue.enqueue(40); // Adding a new element
        System.out.println("Front element is: " + queue.peek()); // Output: 30
    }
}

/*
Circular Queue (Array-Based Queue with Circular Logic)
In a standard array-based queue, as elements are dequeued, the space at the beginning of the array is wasted. A circular queue solves this issue by reusing the array's space in a circular manner. When the rear of the queue reaches the end of the array,
it wraps around to the beginning if there's space.
Queue Applications:
CPU Scheduling: A circular queue is used in operating systems for task scheduling, like round-robin scheduling.
Breadth-First Search (BFS): Queues are used in the BFS algorithm to explore nodes level by level.
Printer Queue: A queue manages print jobs in the order they are received.
 */