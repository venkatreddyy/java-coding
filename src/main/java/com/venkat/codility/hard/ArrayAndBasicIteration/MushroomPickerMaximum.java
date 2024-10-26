package com.venkat.codility.hard.ArrayAndBasicIteration;

public class MushroomPickerMaximum {

    public static int maxMushrooms(int[] A, int start, int K) {
        int n = A.length;
        int[] prefixSum = new int[n + 1];

        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        int maxMushrooms = 0;

        // Check all possible left and right movements within K steps
        for (int p = 0; p <= K; p++) {
            int leftPos = Math.max(0, start - p);
            int rightPos = Math.min(n - 1, start + (K - 2 * p));
            maxMushrooms = Math.max(maxMushrooms, prefixSum[rightPos + 1] - prefixSum[leftPos]);

            leftPos = Math.max(0, start - (K - 2 * p));
            rightPos = Math.min(n - 1, start + p);
            maxMushrooms = Math.max(maxMushrooms, prefixSum[rightPos + 1] - prefixSum[leftPos]);
        }

        return maxMushrooms;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 7, 5, 1, 3, 9};
        int start = 4;
        int K = 6;
        int result = maxMushrooms(A, start, K);
        System.out.println("Maximum Mushrooms Collected: " + result); // Output: 25
    }
}

