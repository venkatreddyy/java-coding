package com.venkat.challenges;

public class BubbleSort {
    // Method to perform Bubble Sort on the input array
    public static void bubbleSort(int[] arr) {
        // Get the length of the array
        int n = arr.length;

        // Outer loop: This loop iterates through the array 'n-1' times
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: Traverse the array from index 0 to 'n-i-1'
            // As larger elements "bubble" to the right end, we don't need to check them again in subsequent iterations
            for (int j = 0; j < n - i - 1; j++) {
                // Compare the current element with the next one
                if (arr[j] > arr[j + 1]) {
                    // If the current element is greater than the next one, swap them
                    int temp = arr[j];   // Store the current element in a temporary variable
                    arr[j] = arr[j + 1]; // Move the next element to the current position
                    arr[j + 1] = temp;   // Place the current element in the next position
                }
            }
        }
    }

    // Main method to test the bubbleSort function
    public static void main(String[] args) {
        // Define an array of integers to sort
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        // Call the bubbleSort function to sort the array
        bubbleSort(arr);

        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

