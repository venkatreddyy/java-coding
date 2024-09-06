package com.venkat.features;

public class LambdaThreadBefore {
    public static void main(String[] args) {
        // Creating a thread using an anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread executed using anonymous class");
            }
        }).start();
    }
}

