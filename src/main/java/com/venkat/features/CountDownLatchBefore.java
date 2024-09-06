package com.venkat.features;

//Before Java 8 (Using Simple Join):
class Worker1 extends Thread {
    private final int workerId;

    Worker1(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public void run() {
        System.out.println("Worker " + workerId + " completed work.");
    }
}

public class CountDownLatchBefore {
    public static void main(String[] args) throws InterruptedException {
        Worker1 w1 = new Worker1(1);
        Worker1 w2 = new Worker1(2);

        w1.start();
        w2.start();

        // Wait for both threads to finish
        w1.join();
        w2.join();

        System.out.println("All workers finished.");
    }
}

