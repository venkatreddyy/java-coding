package com.venkat.threading;

import java.util.Queue;

class Consumer implements Runnable {
    private final Queue<Integer> sharedQueue;

    public Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (sharedQueue) {
            while (sharedQueue.isEmpty()) {
                sharedQueue.wait();
            }
            int value = sharedQueue.poll();
            System.out.println("Consumed: " + value);
            sharedQueue.notifyAll();
        }
    }
}
