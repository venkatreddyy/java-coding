package com.venkat.codility.medium.ArrayAndBasicIteration;

public class MaxCounter {
    public static int[] maxCounter(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0, lastMax = 0;

        for (int i : A) {
            if (i >= 1 && i <= N) {
                counters[i - 1] = Math.max(counters[i - 1], lastMax);
                counters[i - 1]++;
                max = Math.max(max, counters[i - 1]);
            } else if (i == N + 1) {
                lastMax = max; // Update all counters to the current maximum
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], lastMax); // Apply delayed "max" operation
        }
        return counters;
    }

    public static void main(String[] args) {
        int[] result = maxCounter(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        System.out.println("Counters: " + java.util.Arrays.toString(result)); // Output: [3, 2, 2, 4, 2]
    }
}

