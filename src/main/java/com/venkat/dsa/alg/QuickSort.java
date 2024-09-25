package com.venkat.dsa.alg;

/*
Quicksort is a highly efficient, comparison-based, divide-and-conquer sorting algorithm. It works by selecting a "pivot" element from the array and partitioning the other elements into two sub-arrays: elements less than the pivot and elements greater than the pivot. The sub-arrays are then recursively sorted.

How It Works
Choose a Pivot: Select an element from the array to be the pivot. Common choices for the pivot include the first element, the last element, or a randomly selected element.
Partitioning: Rearrange the array such that all elements less than the pivot are on the left, and all elements greater than the pivot are on the right.
Recursion: Recursively apply the same process to the left and right sub-arrays.
Base Case: Recursion terminates when sub-arrays have one or zero elements, which are trivially sorted.


Let's break down Quicksort step-by-step using the array [64, 34, 25, 12, 22, 11, 90, 5] as an example. We’ll go through the full process, explain the partitioning, pivot selection, and how the recursive nature works to sort the array.

Array: [64, 34, 25, 12, 22, 11, 90, 5]
Step 1: Choose a Pivot
In quicksort, the first step is to choose a pivot. We'll use the last element (5) as the pivot for this example.
Initial Array: [64, 34, 25, 12, 22, 11, 90, 5]
Pivot = 5
Step 2: Partitioning
Partitioning involves rearranging the array so that elements smaller than the pivot (5) are on the left,
and elements greater than the pivot are on the right.

Process:
Start scanning from the left.
Compare each element with the pivot (5).
Swap elements to ensure that elements smaller than the pivot move to the left.
Let’s go through the partitioning process:

Compare 64 with 5: 64 > 5, no swap.
Compare 34 with 5: 34 > 5, no swap.
Compare 25 with 5: 25 > 5, no swap.
Compare 12 with 5: 12 > 5, no swap.
Compare 22 with 5: 22 > 5, no swap.
Compare 11 with 5: 11 > 5, no swap.
Compare 90 with 5: 90 > 5, no swap.
Finally, swap the pivot (5) with the first element greater than the pivot, which is 64.

Array after first partitioning: [5, 34, 25, 12, 22, 11, 90, 64]
Pivot (5) is now in its correct sorted position at index 0.
Left sub-array: [] (no elements smaller than 5)
Right sub-array: [34, 25, 12, 22, 11, 90, 64] (unsorted)
Step 3: Recursive Quicksort on Right Sub-Array
Now, we recursively apply quicksort to the right sub-array [34, 25, 12, 22, 11, 90, 64].

Right Sub-Array: [34, 25, 12, 22, 11, 90, 64]
Pivot = 64 (last element)
Step 4: Partitioning the Right Sub-Array
Compare 34 with 64: 34 < 64, swap 34 with itself.
Compare 25 with 64: 25 < 64, swap 25 with itself.
Compare 12 with 64: 12 < 64, swap 12 with itself.
Compare 22 with 64: 22 < 64, swap 22 with itself.
Compare 11 with 64: 11 < 64, swap 11 with itself.
Compare 90 with 64: 90 > 64, no swap.
Finally, swap the pivot (64) with the first element greater than it, which is 90.

Array after partitioning: [5, 34, 25, 12, 22, 11, 64, 90]
Pivot (64) is now in its correct sorted position at index 6.
Left sub-array: [34, 25, 12, 22, 11]
Right sub-array: [90] (already sorted)
Step 5: Recursive Quicksort on Left Sub-Array [34, 25, 12, 22, 11]
Now, we apply quicksort on the left sub-array [34, 25, 12, 22, 11].

Left Sub-Array: [34, 25, 12, 22, 11]
Pivot = 11 (last element)
Step 6: Partitioning the Left Sub-Array
Compare 34 with 11: 34 > 11, no swap.
Compare 25 with 11: 25 > 11, no swap.
Compare 12 with 11: 12 > 11, no swap.
Compare 22 with 11: 22 > 11, no swap.
Finally, swap the pivot (11) with the first element greater than it, which is 34.

Array after partitioning: [5, 11, 25, 12, 22, 34, 64, 90]
Pivot (11) is now in its correct sorted position at index 1.
Left sub-array: [] (no elements smaller than 11)
Right sub-array: [25, 12, 22, 34]
Step 7: Recursive Quicksort on Right Sub-Array [25, 12, 22, 34]
Now, apply quicksort on the sub-array [25, 12, 22, 34].

Sub-Array: [25, 12, 22, 34]
Pivot = 34
Step 8: Partitioning
Compare 25 with 34: 25 < 34, swap 25 with itself.
Compare 12 with 34: 12 < 34, swap 12 with itself.
Compare 22 with 34: 22 < 34, swap 22 with itself.
Finally, swap the pivot (34) with itself.

Array after partitioning: [5, 11, 25, 12, 22, 34, 64, 90]
Pivot (34) is in its correct sorted position at index 5.
Left sub-array: [25, 12, 22]
Right sub-array: [] (already sorted)
Step 9: Recursive Quicksort on [25, 12, 22]
Now apply quicksort on [25, 12, 22].

Sub-Array: [25, 12, 22]
Pivot = 22
Step 10: Partitioning
Compare 25 with 22: 25 > 22, no swap.
Compare 12 with 22: 12 < 22, swap 12 and 25.
Finally, swap the pivot (22) with 25.

Array after partitioning: [5, 11, 12, 22, 25, 34, 64, 90]
Pivot (22) is in its correct sorted position at index 3.
Left sub-array: [12]
Right sub-array: [25] (already sorted)
Step 11: Final Recursive Quicksort on [12]
At this point, all remaining sub-arrays contain one or zero elements, so they are trivially sorted.

Final Sorted Array: [5, 11, 12, 22, 25, 34, 64, 90]
Summary of Quicksort Process:
Choose a Pivot: Usually, the last element is selected as the pivot.
Partition: Rearrange the array so that elements smaller than the pivot are to the left, and larger elements are to the right.
Recursive Sorting: Recursively apply the quicksort algorithm to the left and right sub-arrays.
Termination: The recursion terminates when each sub-array has one or zero elements, which are naturally sorted.
Key Points:
Efficiency: Quicksort typically has a time complexity of O(n log n), though it can degrade to O(n²) in the worst case (e.g., if the pivot is consistently chosen poorly).
In-place Sorting: Quicksort sorts the array in place, requiring only constant additional memory.
Divide and Conquer: The recursive nature allows quicksort to effectively break down large problems (unsorted arrays) into smaller, more manageable sub-problems.
Let me know if you have any further questions!



Time Complexity
Best case: O(n log n) — occurs when the pivot divides the array into two nearly equal parts.
Worst case: O(n²) — occurs when the pivot is always the smallest or largest element, resulting in highly unbalanced partitions (e.g., when the array is already sorted).
Average case: O(n log n) — typical case when the pivot splits the array into relatively balanced partitions.
Characteristics
In-place: Yes (only requires a constant amount of extra memory, but extra space is required for recursion).
Stable: No (equal elements may change their relative order).
Efficient: Quicksort is one of the fastest sorting algorithms for large datasets and is often preferred in practical scenarios.
Optimizations
Pivot Selection: Randomly selecting the pivot or using the "median of three" rule (median of the first, middle, and last element) can improve performance and reduce the chances of hitting the worst case.
Tail Recursion: Optimizing recursive calls to avoid stack overflows for large datasets.

 */
public class QuickSort {

    // Function to partition the array on the basis of the pivot
    private static int partition(int[] array, int lowIndex, int highIndex) {
        // Choose the rightmost element as the pivot
        int pivotValue = array[highIndex];

        // Pointer for the larger element
        int smallerElementIndex = lowIndex - 1;  // Initially outside of the array's range

        // Traverse through all elements in the current sub-array except the pivot
        for (int currentIndex = lowIndex; currentIndex < highIndex; currentIndex++) {
            // If the current element is smaller than or equal to the pivot
            if (array[currentIndex] <= pivotValue) {
                smallerElementIndex++;  // Move the pointer for smaller elements
                // Swap the current element with the element at the smallerElementIndex
                int temp = array[smallerElementIndex];
                array[smallerElementIndex] = array[currentIndex];
                array[currentIndex] = temp;
            }
        }

        // After all elements have been compared, swap the pivot element with the element at smallerElementIndex + 1
        // This ensures that the pivot is in its correct sorted position
        int temp = array[smallerElementIndex + 1];
        array[smallerElementIndex + 1] = array[highIndex];
        array[highIndex] = temp;

        // Return the pivot's final position
        return smallerElementIndex + 1;
    }

    // Main function to implement Quicksort
    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        // If the lowIndex is less than highIndex, we need to sort the array
        if (lowIndex < highIndex) {
            // Find the pivot element such that elements smaller than the pivot are on the left
            // and elements greater than the pivot are on the right
            int pivotIndex = partition(array, lowIndex, highIndex);

            // Recursively apply the same logic to the left and right sub-arrays
            // Sort the elements before the pivot
            quickSort(array, lowIndex, pivotIndex - 1);
            // Sort the elements after the pivot
            quickSort(array, pivotIndex + 1, highIndex);
        }
    }

    // Driver code to test the Quicksort implementation
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 5};  // Sample input array
        // Call the quickSort function with the entire array
        quickSort(array, 0, array.length - 1);  // 0 is the start, array.length-1 is the end of the array

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
/*
Detailed Comments & Variable Names:
pivotValue: The value selected as the pivot for partitioning the array.
smallerElementIndex: A pointer that keeps track of the position where elements smaller than the pivot should be placed.
currentIndex: The index of the current element being compared to the pivot.
partition function: The core function that moves all elements smaller than the pivot to the left and larger to the right.
quickSort function: Recursively sorts the array. It first partitions the array, then applies itself to the left and right portions of the array.
Key Concepts:
============
Pivot Selection: In this case, the rightmost element is selected as the pivot.
Partitioning: The partition function rearranges elements based on the pivot and returns the index where the pivot is finally placed.
Recursive Sorting: After partitioning, the quicksort function recursively sorts the sub-arrays to the left and right of the pivot.
Values:
In this example, the input is {4, 3, 2, 1}, and after each partitioning and recursion, the array becomes sorted as {1, 2, 3, 4}.
 */


