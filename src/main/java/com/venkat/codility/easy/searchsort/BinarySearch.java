package com.venkat.codility.easy.searchsort;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        // Loop until the range is exhausted
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int result = binarySearch(arr, 10);
        System.out.println("Element found at index: " + result); // Output: 3
    }
}
