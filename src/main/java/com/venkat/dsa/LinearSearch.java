package com.venkat.dsa;
/*
Linear Search
Linear Search is one of the simplest search algorithms used to find a target value within an array (or list).
It works by sequentially checking each element of the array, one by one, until the target value is found
or the end of the array is reached.

How It Works:
Start from the first element of the array.
Compare the current element with the target value.
If the current element matches the target, return the index of the element.
If the target value is not found after traversing the entire array, return -1 (or another signal that indicates the value is not present).
Time Complexity:
Best case: O(1) — when the target is the first element in the array.
Worst case: O(n) — when the target is the last element or not present at all.
Average case: O(n) — on average, you will search through half the array before finding the target.
Space Complexity:
O(1) — because linear search does not require extra space.
 */
public class LinearSearch {

    // Function to perform linear search
    public static int linearSearch(int[] array, int target) {
        // Traverse the entire array
        for (int i = 0; i < array.length; i++) {
            // Check if the current element matches the target
            if (array[i] == target) {
                return i; // Return the index if the element is found
            }
        }
        return -1; // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        // Example array and target value
        int[] array = {10, 25, 30, 45, 50, 65};
        int target = 45;

        // Call linearSearch function
        int result = linearSearch(array, target);

        // Print the result
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}

