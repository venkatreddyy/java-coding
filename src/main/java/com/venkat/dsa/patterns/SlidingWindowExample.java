package com.venkat.dsa.patterns;
/*
The Sliding Window technique is a very useful method for solving a variety of array and string manipulation problems. It involves maintaining a subset of elements from a given array or string that moves or "slides" across the data. This approach is effective when dealing with problems related to subarrays or substrings, especially where we need to compute something over a fixed or variable size window of data.

Types of Sliding Windows
Fixed-Size Sliding Window: The window size is constant, and you move the window over the array to compute the desired result.
Variable-Size Sliding Window: The window size can change dynamically based on conditions as you slide through the data.
Basic Concept
 For example, you are asked to find the maximum sum of k consecutive elements in an array:

Explanation:
    We calculate the sum of the first window of size k.
    Then, as the window moves, instead of recalculating the sum from scratch, we subtract the element that falls out of the window and add the element that comes into the window.
    This reduces the time complexity from O(n * k) to O(n).
Common Sliding Window Problems:
    Maximum sum of subarray of size k (fixed window).
    Smallest subarray with a sum greater than or equal to S (variable window).
    Longest substring without repeating characters (variable window).
Permutation in String (variable window).
    Let me know if you have a specific problem or more advanced scenario you'd like to discuss regarding the sliding window!


 */
public class SlidingWindowExample {

    // Function to find the maximum sum of k consecutive elements
    public static int maxSum(int[] arr, int k) {
        // Edge case: If the size of the array is less than k
        if (arr.length < k) {
            System.out.println("Invalid operation, array size is smaller than the window size.");
            return -1;
        }

        // Calculate the sum of the first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Initialize the maxSum with the sum of the first window
        int maxSum = windowSum;

        // Slide the window, updating the sum by subtracting the element going out of the window and adding the new element
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 8, 7, 9, 6};
        int k = 3; // Window size
        System.out.println("Maximum sum of " + k + " consecutive elements: " + maxSum(arr, k));
    }
}

