package com.venkat.challenges;

public class BinarySearch {
    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        // Initialize two pointers: 'left' at the start of the array and 'right' at the end
        int left = 0, right = arr.length - 1;

        // Loop until the search space is valid (when left is less than or equal to right)
        while (left <= right) {
            // Calculate the middle index to avoid integer overflow
            int mid = left + (right - left) / 2;

            // If the target value is found at mid, return its index
            if (arr[mid] == target)
                return mid;

            // If the target is greater than the mid-element, search the right half
            if (arr[mid] < target)
                left = mid + 1;

                // If the target is smaller than the mid-element, search the left half
            else
                right = mid - 1;
        }

        // If the target is not found, return -1
        return -1;
    }

    // Main method to test the binarySearch function
    public static void main(String[] args) {
        // Define a sorted array
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // Search for the value 5 in the array and print the index where it's found
        System.out.println(binarySearch(arr, 5));  // Output: 4
    }
}


