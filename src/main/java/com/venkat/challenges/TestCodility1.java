package com.venkat.challenges;

public class TestCodility1 {
    static int minRemove(int arr[], int n) {
        int[] LIS = new int[n]; // Array to store lengths of increasing subsequences
        int len = 1;  // Track length of the longest subsequence

        // Initialize all LIS values as 1
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
        }

        // Calculate LIS without the additional constraint
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Remove the constraint and only check if arr[i] > arr[j]
                if (arr[i] > arr[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            len = Math.max(len, LIS[i]);
            System.out.println("LIS[" + i + "] = " + LIS[i]); // Add this line for debugging
        }

        // Return min changes for array to strictly increasing
        return n - len;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 1, 3, 5};
        int n = arr.length;
        System.out.println("Minimum removals to make array strictly increasing: " + minRemove(arr, n));
    }

}

