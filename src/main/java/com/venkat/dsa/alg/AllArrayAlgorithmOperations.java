package com.venkat.dsa.alg;

public class AllArrayAlgorithmOperations {

    // Bubble Sort Algorithm
    /*
    This method sorts the input array using the Bubble Sort algorithm. It repeatedly steps through
    the list, compares adjacent elements, and swaps them if they are in the wrong order.
    */
    public void bubbleSort(int[] arr) {
        // Outer loop to iterate over the entire array
        for (int i = 0; i < arr.length - 1; i++)
            // Inner loop to perform the bubble-up process
            for (int j = 0; j < arr.length - i - 1; j++)
                // Swap if the current element is greater than the next
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }

    // Selection Sort Algorithm
    /*
    This method sorts the array using the Selection Sort algorithm. It repeatedly selects the
    minimum element from the unsorted portion and swaps it with the first unsorted element.
    */
    public void selectionSort(int[] arr) {
        // Outer loop to iterate over the array
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i; // Assume the first element of the unsorted portion is the minimum
            // Inner loop to find the minimum element in the unsorted portion
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx]) minIdx = j; // Update minIdx if a smaller element is found
            swap(arr, i, minIdx); // Swap the found minimum element with the first unsorted element
        }
    }

    // Insertion Sort Algorithm
    /*
    This method sorts the array using the Insertion Sort algorithm. It builds the sorted array one element
    at a time by comparing the current element with those before it and inserting it in the correct position.
    */
    public void insertionSort(int[] arr) {
        // Outer loop starting from the second element (first element is considered sorted)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Key element to be inserted
            int j = i - 1;
            // Move elements of the sorted portion that are greater than key one position ahead
            while (j >= 0 && arr[j] > key) arr[j + 1] = arr[j--];
            arr[j + 1] = key; // Place key in its correct position
        }
    }

    // Quick Sort Algorithm
    /*
    This method sorts the array using the Quick Sort algorithm. It picks a pivot element, partitions
    the array around the pivot, and recursively sorts the partitions.
    */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Get the partition index
            quickSort(arr, low, pi - 1);  // Recursively sort elements before the partition
            quickSort(arr, pi + 1, high); // Recursively sort elements after the partition
        }
    }

    // Merge Sort Algorithm
    /*
    This method sorts the array using the Merge Sort algorithm. It divides the array into two halves,
    recursively sorts them, and then merges the two sorted halves.
    */
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; // Find the middle point
            mergeSort(arr, l, m); // Recursively sort the first half
            mergeSort(arr, m + 1, r); // Recursively sort the second half
            merge(arr, l, m, r); // Merge the sorted halves
        }
    }

    // Counting Sort Algorithm
    /*
    This method sorts the array using the Counting Sort algorithm. It counts the occurrences of each element,
    builds a cumulative count, and then places the elements in their sorted position.
    */
    public void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1]; // Initialize the count array
        // Store the count of each element
        for (int i : arr) count[i]++;
        // Change count[i] to store the cumulative count
        for (int i = 1; i <= max; i++) count[i] += count[i - 1];
        // Build the sorted output array
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) output[--count[arr[i]]] = arr[i];
        // Copy the sorted output array into the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // Radix Sort Algorithm
    /*
    This method sorts the array using the Radix Sort algorithm. It sorts the array by processing individual
    digits, starting from the least significant digit.
    */
    public void radixSort(int[] arr) {
        int max = getMax(arr); // Get the maximum value in the array
        // Perform counting sort for every digit, starting from the least significant digit
        for (int exp = 1; max / exp > 0; exp *= 10) countSortByDigit(arr, exp);
    }

    // Linear Search Algorithm
    /*
    This method performs a linear search on the array. It sequentially checks each element
    until the target value is found.
    */
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i; // Return the index if the target is found
        return -1; // Return -1 if the target is not found
    }

    // Binary Search Algorithm
    /*
    This method performs a binary search on a sorted array. It repeatedly divides the search interval in half,
    checking whether the target value is greater or smaller than the middle element.
    */
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // Find the middle element
            if (arr[mid] == target) return mid; // Return the index if the target is found
            if (arr[mid] < target) low = mid + 1; // Search in the right half
            else high = mid - 1; // Search in the left half
        }
        return -1; // Return -1 if the target is not found
    }

    // Helper function to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // Temporary variable to store one of the elements
        arr[i] = arr[j]; // Swap the elements
        arr[j] = temp; // Assign the temporary value to the other position
    }

    // Partition function for Quick Sort
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot as the last element
        int i = low - 1; // Index of the smaller element
        // Traverse through the array and place elements smaller than the pivot to the left
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) swap(arr, ++i, j);
        swap(arr, i + 1, high); // Place the pivot in its correct position
        return i + 1; // Return the partition index
    }

    // Merge function for Merge Sort
    private void merge(int[] arr, int l, int m, int r) {
        // Create temporary arrays to hold the split parts
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1); // Copy the left part
        System.arraycopy(arr, m + 1, R, 0, n2); // Copy the right part
        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++]; // Copy remaining elements of L
        while (j < n2) arr[k++] = R[j++]; // Copy remaining elements of R
    }

    // Helper function for Radix Sort (Counting Sort by digit)
    private void countSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length], count = new int[10];
        // Count occurrences of digits
        for (int i : arr) count[(i / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1]; // Build cumulative count
        for (int i = arr.length - 1; i >= 0; i--) output[--count[(arr[i] / exp) % 10]] = arr[i]; // Build output
        System.arraycopy(output, 0, arr, 0, arr.length); // Copy output to the original array
    }

    // Get the maximum value in the array
    private int getMax(int[] arr) {
        int max = arr[0]; // Assume the first element is the maximum
        for (int i : arr) if (i > max) max = i; // Update max if a larger element is found
        return max; // Return the maximum value
    }

    // Main method to test sorting and searching algorithms
    public static void main(String[] args) {
        AllArrayAlgorithmOperations ops = new AllArrayAlgorithmOperations(); // Create an instance of the class
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // Define an unsorted array

        ops.bubbleSort(arr); // Test bubble sort
        ops.selectionSort(arr); // Test selection sort
        ops.insertionSort(arr); // Test insertion sort
        ops.quickSort(arr, 0, arr.length - 1); // Test quick sort
        ops.mergeSort(arr, 0, arr.length - 1); // Test merge sort
        ops.countingSort(arr, 90); // Test counting sort
        ops.radixSort(arr); // Test radix sort
        System.out.println(ops.linearSearch(arr, 25)); // Test linear search
        System.out.println(ops.binarySearch(arr, 25)); // Test binary search
    }
}
