package com.venkat.dsa;

/*
Merge Sort is a popular divide-and-conquer algorithm that works by recursively splitting an array into smaller subarrays, sorting each subarray, and then merging the sorted subarrays to produce a final sorted array.

How Merge Sort Works:
Divide: Split the array into two halves.
Conquer: Recursively sort the two halves.
Combine: Merge the two sorted halves into a single sorted array.
Characteristics:
Time Complexity: O(n log n) for all cases (best, average, and worst).
Space Complexity: O(n) because it requires additional space to merge the sorted subarrays.
Stable Sort: It maintains the relative order of equal elements.
Divide and Conquer: Breaks the problem into smaller sub-problems (subarrays), solves each one, and combines the solutions.
Step-by-Step Example:
Let’s take the array [38, 27, 43, 3, 9, 82, 10] and apply merge sort step by step.

[38, 27, 43, 3, 9, 82, 10]
Step 1: Divide the Array
Split the array in half:

Left half: [38, 27, 43]
Right half: [3, 9, 82, 10]
Recursively split these subarrays:

Left half [38, 27, 43]:
Split further into:
Left: [38]
Right: [27, 43]
Right half [3, 9, 82, 10]:
Split further into:
Left: [3, 9]
Right: [82, 10]
Continue splitting until each subarray has only one element:

[38] (already a single element)
[27, 43] → Split into [27] and [43]
[3, 9] → Split into [3] and [9]
[82, 10] → Split into [82] and [10]
Step 2: Merge the Subarrays
Now, we start merging the sorted subarrays back together.

Merge [27] and [43]:

Compare 27 and 43. Since 27 < 43, the merged result is:
csharp
Copy code
[27, 43]
Merge [38] and [27, 43]:

Compare 38 with 27 and 43. Since 27 < 38, place 27 first. Then compare 38 and 43, and place 38 before 43. The merged result is:
csharp
Copy code
[27, 38, 43]
Merge [3] and [9]:

Compare 3 and 9. Since 3 < 9, the merged result is:
csharp
Copy code
[3, 9]
Merge [82] and [10]:

Compare 82 and 10. Since 10 < 82, the merged result is:
csharp
Copy code
[10, 82]
Merge [3, 9] and [10, 82]:

Compare 3 with 10. Since 3 < 10, place 3 first. Then compare 9 with 10, place 9 next. Finally, add 10 and 82. The merged result is:
csharp
Copy code
[3, 9, 10, 82]
Merge [27, 38, 43] and [3, 9, 10, 82]:

Compare the elements in both arrays step by step:
3 (from right array) < 27, so 3 comes first.
9 < 27, so 9 comes next.
10 < 27, so 10 comes next.
Then 27, 38, 43, and 82 follow in order.
The final merged result is:

csharp
Copy code
[3, 9, 10, 27, 38, 43, 82]
Final Sorted Array:
csharp
Copy code
[3, 9, 10, 27, 38, 43, 82]
 */
public class MergeSort {

    // Function to merge two sorted subarrays into a single sorted array
    public static void merge(int[] array, int left, int middle, int right) {
        // Sizes of the two subarrays to be merged
        int n1 = middle - left + 1; // Number of elements in the left subarray
        int n2 = right - middle;    // Number of elements in the right subarray

        // Temporary arrays to hold the elements of the left and right subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy the elements from the original array to the left and right temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the leftArray and rightArray back into the original array in sorted order
        int i = 0, j = 0; // Initial indexes for leftArray and rightArray
        int k = left;     // Initial index for the merged array (starting from 'left')

        // Compare elements from both subarrays and insert the smaller one into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i]; // Insert the element from leftArray if it's smaller
                i++; // Move to the next element in leftArray
            } else {
                array[k] = rightArray[j]; // Insert the element from rightArray if it's smaller
                j++; // Move to the next element in rightArray
            }
            k++; // Move to the next position in the merged array
        }

        // If there are any remaining elements in leftArray, copy them to the original array
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // If there are any remaining elements in rightArray, copy them to the original array
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Function to recursively split the array and then merge the subarrays
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle index of the current array segment
            int middle = (left + right) / 2;

            // Recursively sort the left half of the array (from 'left' to 'middle')
            mergeSort(array, left, middle);

            // Recursively sort the right half of the array (from 'middle + 1' to 'right')
            mergeSort(array, middle + 1, right);

            // Merge the sorted left and right halves
            merge(array, left, middle, right);
        }
    }

    public static void main(String[] args) {
        // Input array that we want to sort
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        // Call the mergeSort function to sort the array (initial call is for the entire array)
        mergeSort(array, 0, array.length - 1);

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
