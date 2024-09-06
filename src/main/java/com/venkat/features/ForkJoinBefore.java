package com.venkat.features;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SimpleTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working");
    }
}

public class ForkJoinBefore {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executor.submit(new SimpleTask());
        }
        executor.shutdown();
    }
}

