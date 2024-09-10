package com.venkat.dsa;

/*
Selection sort is an in-place comparison sorting algorithm.
It divides the array into two parts: the sorted part and the unsorted part.
It repeatedly selects the smallest (or largest, depending on sorting order)
element from the unsorted part and swaps it with the leftmost unsorted element,
moving the boundary between the sorted and unsorted parts by one element.

How It Works
Step 1: Start with the first element in the array, assume it's the smallest.
Step 2: Scan through the rest of the array to find the actual smallest element.
Step 3: Swap the smallest element with the first element.
Step 4: Move to the second element and repeat the process, continuing until the entire array is sorted.
Example
For the array [4, 3, 2, 1], selection sort would work like this:

Find the smallest element in the array (1) and swap it with the first element → [1, 3, 2, 4]
Find the smallest element in the remaining unsorted portion (2) and swap it with the second element → [1, 2, 3, 4]
Find the smallest element in the remaining unsorted portion (3) and swap it with the third element → [1, 2, 3, 4]
The array is now sorted.
 */
public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;

        // Traverse through the entire array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        selectionSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
