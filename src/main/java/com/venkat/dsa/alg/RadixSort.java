package com.venkat.dsa.alg;

public class RadixSort {

    // Function to get the maximum value in the array
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // A function to do counting sort based on the digit represented by exp (exponent)
    public static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];  // Output array to store sorted numbers
        int[] count = new int[10];  // Count array for each digit (0-9)

        // Step 1: Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10; // Extract the digit at the current place (exp)
            count[digit]++;
        }

        // Step 2: Modify the count array to store cumulative positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;  // Decrease the count for next occurrence
        }

        // Step 4: Copy the sorted array back to the original array
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Main function to implement Radix Sort
    public static void radixSort(int[] array) {
        // Step 1: Find the maximum number to know the number of digits
        int max = getMax(array);

        // Step 2: Perform counting sort for each digit (ones, tens, hundreds, ...)
        // exp is 1 for ones, 10 for tens, 100 for hundreds, etc.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};  // Sample input array
        radixSort(array);  // Call Radix Sort

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
