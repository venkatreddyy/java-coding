package com.venkat.hundred.concurrency;
/*
10. Design an Elevator System
This is a simplified version of an elevator system design. It supports moving between floors and processing requests from multiple threads.
 */
import java.util.PriorityQueue;

enum Direction {
    UP, DOWN, IDLE
}

class Elevator {
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private PriorityQueue<Integer> upRequests = new PriorityQueue<>();
    private PriorityQueue<Integer> downRequests = new PriorityQueue<>((a, b) -> b - a);

    public synchronized void requestFloor(int floor) {
        if (floor > currentFloor) {
            upRequests.add(floor);
        } else if (floor < currentFloor) {
            downRequests.add(floor);
        }
        notifyAll(); // Notify the elevator to process requests
    }

    public synchronized void run() throws InterruptedException {
        while (true) {
            while (upRequests.isEmpty() && downRequests.isEmpty()) {
                wait(); // Wait for requests
            }

            if (!upRequests.isEmpty()) {
                direction = Direction.UP;
                moveToNextFloor(upRequests.poll());
            } else if (!downRequests.isEmpty()) {
                direction = Direction.DOWN;
                moveToNextFloor(downRequests.poll());
            }
        }
    }

    private void moveToNextFloor(int nextFloor) throws InterruptedException {
        while (currentFloor != nextFloor) {
            if (direction == Direction.UP) {
                currentFloor++;
            } else if (direction == Direction.DOWN) {
                currentFloor--;
            }
            System.out.println("Elevator at floor: " + currentFloor);
            Thread.sleep(1000);
        }
        direction = Direction.IDLE; // Stop when the destination is reached
        System.out.println("Elevator stopped at floor: " + currentFloor);
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        // Start the elevator thread
        new Thread(() -> {
            try {
                elevator.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Simulate floor requests
        new Thread(() -> elevator.requestFloor(3)).start();
        new Thread(() -> elevator.requestFloor(5)).start();
        new Thread(() -> elevator.requestFloor(1)).start();
    }
}

