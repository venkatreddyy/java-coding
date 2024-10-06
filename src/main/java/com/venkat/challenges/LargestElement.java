package com.venkat.challenges;

public class LargestElement {
    // Method to find the largest element in the input array
    public static int findLargest(int[] arr) {
        // Initialize the largest variable with the first element of the array
        int largest = arr[0];

        // Loop through each element in the array
        for (int num : arr) {
            // If the current element is greater than the current largest, update the largest
            if (num > largest) {
                largest = num;
            }
        }

        // Return the largest element found
        return largest;
    }

    // Main method to test the findLargest function
    public static void main(String[] args) {
        // Define an array of integers
        int[] arr = {1, 3, 7, 2, 5};

        // Call the findLargest function and print the result
        System.out.println(findLargest(arr));  // Output: 7
    }
}


