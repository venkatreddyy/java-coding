package com.venkat.features;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAfter {
    public static void main(String[] args) {
        // Asynchronous computation using CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        // Handling result after computation is complete
        future.thenAccept(result -> System.out.println("Result: " + result));

        // Pause the main thread to allow async task to complete
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

