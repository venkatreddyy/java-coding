package com.venkat.threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        int size = 5;

        Thread producerThread = new Thread(new Producer(sharedQueue, size));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        producerThread.start();
        consumerThread.start();
    }
}

/*
Explanation
Producer Class:

Implements Runnable interface.
In the produce method, the producer thread waits if the queue is full, otherwise adds a value to the queue and notifies all waiting threads.
Consumer Class:
Implements Runnable interface.
In the consume method, the consumer thread waits if the queue is empty, otherwise removes a value from the queue and notifies all waiting threads.
Main Class:

Creates and starts both producer and consumer threads with a shared queue of a specified size.
 */