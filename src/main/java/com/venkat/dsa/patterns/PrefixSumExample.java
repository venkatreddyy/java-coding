package com.venkat.dsa.patterns;

public class PrefixSumExample {

    // Function to compute the prefix sum of an array
    public static int[] computePrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];

        // First element is the same in both arrays
        prefixSum[0] = arr[0];

        // Fill the prefix sum array
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }

    // Function to get the sum of elements from index l to r
    public static int getRangeSum(int[] prefixSum, int l, int r) {
        if (l == 0) {
            return prefixSum[r];
        } else {
            return prefixSum[r] - prefixSum[l - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int[] prefixSum = computePrefixSum(arr);

        // Output prefix sum array
        System.out.print("Prefix Sum Array: ");
        for (int sum : prefixSum) {
            System.out.print(sum + " ");
        }

        // Example: Find the sum from index 1 to 3 (4 + 6 + 8)
        int l = 1;
        int r = 3;
        System.out.println("\nSum from index " + l + " to " + r + ": " + getRangeSum(prefixSum, l, r));
    }
}

