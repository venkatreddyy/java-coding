package com.venkat.hundred.concurrency;
/*
9. Multithreading: Print Odd and Even Numbers Alternately
This program uses two threads to alternately print odd and even numbers.
 */
class PrintOddEven {
    private boolean oddTurn = true;
    private final int max = 10;

    // Thread to print even numbers
    class Even implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= max; i += 2) {
                synchronized (PrintOddEven.this) {
                    while (oddTurn) {
                        try {
                            PrintOddEven.this.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    oddTurn = true;
                    PrintOddEven.this.notify();
                }
            }
        }
    }

    // Thread to print odd numbers
    class Odd implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= max; i += 2) {
                synchronized (PrintOddEven.this) {
                    while (!oddTurn) {
                        try {
                            PrintOddEven.this.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    oddTurn = false;
                    PrintOddEven.this.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEven poe = new PrintOddEven();
        Thread oddThread = new Thread(poe.new Odd());
        Thread evenThread = new Thread(poe.new Even());

        oddThread.start();
        evenThread.start();
    }
}

