package com.venkat.codility.medium.searchAndSort;

public class SearchInRotatedSortedArray {
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1; // Target in left half
                } else {
                    low = mid + 1; // Target in right half
                }
            }
            // Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1; // Target in right half
                } else {
                    high = mid - 1; // Target in left half
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(arr, target);
        System.out.println("Target found at index: " + result); // Output: 4
    }
}

