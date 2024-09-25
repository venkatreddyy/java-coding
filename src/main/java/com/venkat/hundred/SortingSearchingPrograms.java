package com.venkat.hundred;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
Explanation:
Binary Search:
Input: {12, 11, 13, 5, 6, 7}, target 13
Output: Index 2 (assuming the array is sorted)
Quick Sort:
Input: {12, 11, 13, 5, 6, 7}
Output: [5, 6, 7, 11, 12, 13]
Merge Sort:
Input: {12, 11, 13, 5, 6, 7}
Output: [5, 6, 7, 11, 12, 13]
Heap Sort:
Input: {12, 11, 13, 5, 6, 7}
Output: [5, 6, 7, 11, 12, 13]
Find Kth Largest Element:
Input: {3, 2, 1, 5, 6, 4}, k = 2
Output: 5
Find Majority Element:
Input: {2, 2, 1, 1, 2, 2}
Output: 2
Key Points:
Each sorting algorithm is implemented to sort arrays in-place.
Binary search finds the index of a target element in a sorted array.
Kth Largest Element is found using a Min-Heap.
The Majority Element is found using the Boyer-Moore Voting Algorithm.
These examples are well-commented, with inputs and outputs provided. Let me know if you need further clarification!
 */
public class SortingSearchingPrograms {

    // 1. Binary Search Implementation
    // Binary search works on sorted arrays and returns the index of the target element.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;  // Initialize left boundary
        int right = arr.length - 1;  // Initialize right boundary

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Find the middle element to avoid overflow

            if (arr[mid] == target) {
                return mid;  // Target found
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }
        return -1;  // Target not found
    }

    // 2. Quick Sort Implementation
    // Quick Sort is a divide-and-conquer algorithm. It sorts in-place using partitioning.
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Partition the array and get the pivot index

            quickSort(arr, low, pi - 1);  // Sort the left partition
            quickSort(arr, pi + 1, high);  // Sort the right partition
        }
    }

    // Partition function for quick sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Use the last element as pivot
        int i = low - 1;  // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);  // Swap if the current element is smaller than the pivot
            }
        }
        swap(arr, i + 1, high);  // Place the pivot in its correct position
        return i + 1;  // Return pivot index
    }

    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 3. Merge Sort Implementation
    // Merge Sort is a divide-and-conquer algorithm that uses merging to sort the array.
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;  // Find the midpoint

            mergeSort(arr, left, mid);  // Sort the left half
            mergeSort(arr, mid + 1, right);  // Sort the right half

            merge(arr, left, mid, right);  // Merge the sorted halves
        }
    }

    // Merge function for merge sort
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;  // Size of the left subarray
        int n2 = right - mid;  // Size of the right subarray

        int[] L = new int[n1];  // Left subarray
        int[] R = new int[n2];  // Right subarray

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge the two subarrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // 4. Heap Sort Implementation
    // Heap Sort sorts the array using the properties of a binary heap.
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);  // Move the current root to the end
            heapify(arr, i, 0);  // Heapify the reduced heap
        }
    }

    // Heapify function to maintain the heap property
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2;  // Right child

        // If the left child is larger than the root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If the right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Swap and continue heapifying if the largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);  // Recursively heapify the affected sub-tree
        }
    }

    // 5. Find the Kth Largest Element in an Array
    // This function uses a Min-Heap to find the Kth largest element.
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);  // Min-Heap to store K largest elements

        for (int num : arr) {
            minHeap.offer(num);  // Add the current element to the heap
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest element if the heap size exceeds k
            }
        }
        return minHeap.peek();  // The Kth largest element will be at the root of the min-heap
    }

    // 6. Find Majority Element in an Array
    // Majority element appears more than n/2 times. Boyer-Moore Voting Algorithm is used here.
    public static int findMajorityElement(int[] arr) {
        int count = 0, candidate = -1;

        // First phase to find the candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;  // Set candidate
            }
            count += (num == candidate) ? 1 : -1;  // Increment or decrement the count
        }

        // Second phase to verify if the candidate is actually the majority element
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // Check if candidate is majority
        if (count > arr.length / 2) {
            return candidate;
        } else {
            return -1;  // No majority element found
        }
    }

    public static void main(String[] args) {
        // Input array for sorting and searching algorithms
        int[] arr = {12, 11, 13, 5, 6, 7};

        // 1. Binary Search
        System.out.println("Binary Search (Element 13): " + binarySearch(arr, 13));
        // Output: Binary Search (Element 13): Index 2 (Assuming array is sorted)

        // 2. Quick Sort
        int[] quickSortArr = {12, 11, 13, 5, 6, 7};
        quickSort(quickSortArr, 0, quickSortArr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickSortArr));
        // Output: Quick Sort: [5, 6, 7, 11, 12, 13]

        // 3. Merge Sort
        int[] mergeSortArr = {12, 11, 13, 5, 6, 7};
        mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortArr));
        // Output: Merge Sort: [5, 6, 7, 11, 12, 13]

        // 4. Heap Sort
        int[] heapSortArr = {12, 11, 13, 5, 6, 7};
        heapSort(heapSortArr);
        System.out.println("Heap Sort: " + Arrays.toString(heapSortArr));
        // Output: Heap Sort: [5, 6, 7, 11, 12, 13]

        // 5. Find Kth Largest Element
        int[] kthLargestArr = {3, 2, 1, 5, 6, 4};
        System.out.println("Kth Largest Element (2nd largest): " + findKthLargest(kthLargestArr, 2));
        // Output: Kth Largest Element (2nd largest): 5

        // 6. Find Majority Element
        int[] majorityElementArr = {2, 2, 1, 1, 2, 2};
        System.out.println("Majority Element: " + findMajorityElement(majorityElementArr));
        // Output: Majority Element: 2
    }
}

