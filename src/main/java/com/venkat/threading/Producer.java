package com.venkat.threading;

import java.util.Queue;

class Producer implements Runnable {
    private final Queue<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                produce(value++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int value) throws InterruptedException {
        synchronized (sharedQueue) {
            while (sharedQueue.size() == SIZE) {
                sharedQueue.wait();
            }
            sharedQueue.add(value);
            System.out.println("Produced: " + value);
            sharedQueue.notifyAll();
        }
    }
}

