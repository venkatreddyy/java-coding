package com.venkat.dsa;

/*
Binary Search is an efficient search algorithm that finds the position of a target value within a sorted array.
 It works by repeatedly dividing the search range in half. Binary search compares the target value to the middle
 element of the array, and based on the comparison, it either continues the search in the left or right half of the array.

Key Concept:
Array must be sorted for binary search to work.
It eliminates half of the elements in each step, making it much faster than linear search for large datasets.
How It Works:
Start by comparing the target value with the middle element of the array.
If the target value is equal to the middle element, return the index of the middle element.
If the target value is less than the middle element, repeat the search in the left half of the array.
If the target value is greater than the middle element, repeat the search in the right half of the array.
Continue this process until the target is found or the subarray size becomes zero (i.e., the target is not found).
Time Complexity:
Best case: O(1) — when the target is the middle element on the first comparison.
Worst case: O(log n) — because the array is halved in each step.
Average case: O(log n).
Space Complexity:
O(1) for the iterative version (since no extra memory is used).
O(log n) for the recursive version (due to recursion stack).
 */
public class BinarySearch {

    // Function to perform binary search
    public static int binarySearch(int[] array, int target) {
        int left = 0; // Start of the array
        int right = array.length - 1; // End of the array

        // Continue searching while the range is valid
        while (left <= right) {
            int middle = left + (right - left) / 2; // Avoid overflow with this calculation

            // Check if the target is at the middle
            if (array[middle] == target) {
                return middle; // Target found, return the index
            }

            // If target is smaller than middle, it must be in the left subarray
            if (array[middle] > target) {
                right = middle - 1;
            }
            // If target is larger than middle, it must be in the right subarray
            else {
                left = middle + 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Example sorted array and target value
        int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        // Call binarySearch function
        int result = binarySearch(array, target);

        // Print the result
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}

