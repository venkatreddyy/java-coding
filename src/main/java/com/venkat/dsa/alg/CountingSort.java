package com.venkat.dsa.alg;
/*
Counting Sort
Counting Sort is a non-comparative sorting algorithm that sorts elements by counting the occurrences of each unique value. It works by determining the position of each element in the sorted array by using a frequency count.

Counting Sort is particularly efficient when the range of input values (i.e., the difference between the maximum and minimum values) is not significantly larger than the number of elements.

How Counting Sort Works:
Determine the Range: Find the minimum and maximum values in the array.
Create a Count Array: Create an auxiliary array (count array) where the index represents the elements and the value at each index represents the frequency of that element in the input array.
Modify the Count Array: Convert the count array to store the cumulative count, which tells us the position of each element in the output array.
Build the Sorted Output: Use the count array to place each element in its correct position in the sorted output array.
Copy the Output to the Original Array: Finally, copy the sorted elements from the output array back into the original array.
Time Complexity:
Best case: O(n + k)
Worst case: O(n + k)
n is the number of elements.
k is the range of the input (i.e., the difference between the maximum and minimum values).
Space Complexity:
O(n + k), since the algorithm uses an auxiliary array of size k and an output array of size n.
Limitations:
Counting Sort works only for discrete values like integers or characters. It is not suitable for sorting floating-point numbers or strings without modifications.
If the range of input values (k) is very large compared to n, it can become inefficient in terms of space.

 */
public class CountingSort {

    public static void countingSort(int[] array) {
        // Step 1: Find the maximum value in the array manually
        int max = array[0];
        for(int num : array) {
            if(num > max) {
                max = num;
            }
        }
        // Step 2: Create a count array to store the count of each unique number
        int[] count = new int[max + 1]; // Array to store counts of each number

        // Step 3: Count the occurrences of each number
        for (int j : array) {
            count[j]++;
        }

        // Step 4: Modify the count array by adding the cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Create the output array where we will place the sorted elements
        int[] output = new int[array.length];

        // Step 6: Build the output array using the count array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--; // Decrease the count for the next occurrence
        }

        // Step 7: Copy the sorted elements back to the original array
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1}; // Input array to sort
        countingSort(array); // Sort the array

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
/*
Time Complexity:
Time Complexity: O(n + k), where n is the number of elements in the input array and k is the range of the input data (i.e., the difference between the maximum and minimum values).
This makes Counting Sort very efficient when k is not much larger than n.
Space Complexity:
Space Complexity: O(n + k), where n is the number of elements in the array and k is the range of input values.
When to Use Counting Sort:
Counting Sort is useful when the range of input numbers (k) is not significantly larger than the number of elements (n).
It’s an excellent choice when sorting integers or other discrete objects, where the maximum value is known and not too large.
Limitations:
Counting Sort is not suitable for sorting arrays where the values are too large because it would require a very large count array.
It cannot handle negative numbers without some modifications (such as shifting the values).
Let me know if you'd like to explore optimizations or other aspects of Counting Sort!
 */