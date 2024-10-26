package com.venkat.codility.easy.PrefixSumsCountingElements;

public class PrefixSum {
    public static int[] calculatePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        // Calculate prefix sum for each position
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = calculatePrefixSum(arr);
        System.out.println("Prefix Sum Array: " + java.util.Arrays.toString(result));
    }
}

//Output: Prefix Sum Array: [1, 3, 6, 10, 15]