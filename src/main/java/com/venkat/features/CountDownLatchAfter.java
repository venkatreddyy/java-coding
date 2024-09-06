package com.venkat.features;

import java.util.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private final int workerId;
    private final CountDownLatch latch;

    Worker(int workerId, CountDownLatch latch) {
        this.workerId = workerId;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Worker " + workerId + " completed work.");
        latch.countDown();
    }
}

public class CountDownLatchAfter {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Worker w1 = new Worker(1, latch);
        Worker w2 = new Worker(2, latch);

        w1.start();
        w2.start();

        // Wait for both workers to finish
        latch.await();

        System.out.println("All workers finished.");
    }
}
