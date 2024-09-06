package com.venkat.features;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private final int[] numbers;
    private final int start, end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 5) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            SumTask leftTask = new SumTask(numbers, start, middle);
            SumTask rightTask = new SumTask(numbers, middle, end);
            invokeAll(leftTask, rightTask);
            return leftTask.join() + rightTask.join();
        }
    }
}

public class ForkJoinAfter {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        int sum = pool.invoke(new SumTask(numbers, 0, numbers.length));
        System.out.println("Total Sum: " + sum);
    }
}
