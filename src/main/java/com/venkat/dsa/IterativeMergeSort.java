package com.venkat.dsa;
/*
Detailed Explanation:
merge Function:

Purpose: This function merges two sorted subarrays (just like in the recursive version).
It merges the subarrays array[left..middle] and array[middle+1..right] into one sorted subarray.
mergeSort Function (Iterative):

Key Idea: Instead of using recursion to divide the array, we start with subarrays of size 1 (trivially sorted) and iteratively merge larger and larger subarrays.
Outer Loop: The outer loop controls the size of the subarrays being merged. The size starts at 1 (each element is its own sorted subarray)
and doubles with each iteration (size *= 2).
Inner Loop: The inner loop iterates over the array and merges subarrays of the current size.
It sets left as the starting index of the left subarray.
It calculates middle and right to define the boundaries of the two subarrays to be merged.
The merge function is then called to merge these subarrays.
Example Walkthrough:

Let's walk through the process for the array [38, 27, 43, 3, 9, 82, 10].

First iteration (size = 1):

Merge [38] and [27] → Result: [27, 38]
Merge [43] and [3] → Result: [3, 43]
Merge [9] and [82] → Result: [9, 82]
[10] remains unchanged since there's no pair.
Array after size 1 merges: [27, 38, 3, 43, 9, 82, 10]
Second iteration (size = 2):

Merge [27, 38] and [3, 43] → Result: [3, 27, 38, 43]
Merge [9, 82] and [10] → Result: [9, 10, 82]
Array after size 2 merges: [3, 27, 38, 43, 9, 10, 82]
Third iteration (size = 4):

Merge [3, 27, 38, 43] and [9, 10, 82] → Result: [3, 9, 10, 27, 38, 43, 82]
Array is fully sorted: [3, 9, 10, 27, 38, 43, 82]
Key Differences from Recursive Merge Sort:

No recursive calls.
Merges are done iteratively, progressively increasing the size of the subarrays being merged.
Time Complexity:
O(n log n) in all cases (best, average, worst), since we still divide the array in half log(n) times, and each merge operation takes O(n) time.
Space Complexity:
O(n) due to the temporary arrays used during the merging process. Each merge requires space to store the two temporary subarrays.
Advantages of Iterative Merge Sort:
Avoids recursion, which is useful for systems with limited stack space or deep recursion limitations.
Iterative approaches are sometimes more efficient on systems where recursion overhead is significant.
This non-recursive (iterative) implementation of Merge Sort works just as efficiently as the recursive version, but without the need for recursion. Let me know if you have any questions or need further clarification!
 */
public class IterativeMergeSort {

    // Function to merge two sorted subarrays
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = (middle - left) + 1; // Size of the left subarray
        int n2 = right - middle;    // Size of the right subarray

        // Create temporary arrays for left and right subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to the temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the two sorted subarrays into the original array
        int i = 0, j = 0;
        int k = left; // Index for the merged array

        // Merge the elements back into the array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Iterative merge sort function
    public static void mergeSort(int[] array) {
        int n = array.length;

        // Iterate over subarray sizes: 1, 2, 4, 8, ...
        //size *= 2 is a shorthand for:  size = size * 2;
        for (int size = 1; size < n; size *= 2) {
            // Iterate over the entire array, merging subarrays of the current size
            //left = left + 2	left += 2	Increment left by 2
            //left += 2 * size is equivalent to: left = left + (2 * size);
            for (int left = 0; left < n - 1; left += 2 * size) {
                // Find the middle and right boundaries for the subarrays
                int middle = Math.min((left + size) - 1, n - 1);
                int right = Math.min((left + (2 * size)) - 1, n - 1);
/*
The expression left + 2 * size - 1 is evaluated in the following order:
Multiplication: 2 * size
Addition: left + (2 * size)
Subtraction: (left + 2 * size) - 1
 */
                // Merge the two subarrays array[left..middle] and array[middle+1..right]
                merge(array, left, middle, right);
            }
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        // Call the iterative merge sort function
        mergeSort(array);

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

