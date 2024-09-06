package com.venkat.features;

public class LambdaThreadAfter {
    public static void main(String[] args) {
        // Using Lambda Expression to create a thread
        new Thread(() -> System.out.println("Thread executed using Lambda")).start();
    }
}

