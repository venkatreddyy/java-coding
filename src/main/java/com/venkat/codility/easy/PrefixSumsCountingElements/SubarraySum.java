package com.venkat.codility.easy.PrefixSumsCountingElements;

public class SubarraySum {
    public static boolean hasSubarrayWithSum(int[] arr, int sum) {
        int currentSum = 0, start = 0;
        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];
            while (currentSum > sum && start <= end) {
                currentSum -= arr[start++];
            }
            if (currentSum == sum) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        boolean result = hasSubarrayWithSum(arr, 33);
        System.out.println("Subarray with sum 33 exists: " + result);
    }
}

//Output: Subarray with sum 33 exists: true