package com.venkat.dsa.alg;

/*
Bubble sort is a simple comparison-based sorting algorithm. It works by repeatedly stepping through the list,
comparing adjacent elements, and swapping them if they are in the wrong order.
This process is repeated until the list is sorted.

How it Works
Pass through the array: The algorithm compares each pair of adjacent elements, swapping them if they are in the wrong order.
"Bubble" the largest element: After each full pass through the list, the largest unsorted element moves to its correct position at the end of the list.
Repeat: The process is repeated for the remaining unsorted portion of the list.
Example
For the array [4, 3, 2, 1], bubble sort would work like this:

Compare 4 and 3, swap them → [3, 4, 2, 1]
Compare 4 and 2, swap them → [3, 2, 4, 1]
Compare 4 and 1, swap them → [3, 2, 1, 4] (First pass complete)
Compare 3 and 2, swap them → [2, 3, 1, 4]
Compare 3 and 1, swap them → [2, 1, 3, 4] (Second pass complete)
Compare 2 and 1, swap them → [1, 2, 3, 4] (Third pass complete, array sorted)

Time Complexity
Best case: O(n) — if the array is already sorted (with an optimized version of bubble sort that checks for swaps).
Worst case: O(n²) — when the array is sorted in reverse order.
Average case: O(n²).
Characteristics
Stable: Yes (it preserves the order of equal elements).
In-place: Yes (requires only a constant amount of extra space).
Inefficient: Bubble sort is not suitable for large datasets due to its O(n²) time complexity.

 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        // Loop through the entire array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place, so reduce the range
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if the element is greater than the next element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped during a pass, the array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        bubbleSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
