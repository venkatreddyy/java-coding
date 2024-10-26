package com.venkat.codility.easy.searchsort;

public class FirstOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        // Binary search to find the first occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Move left to find earlier occurrences
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int result = findFirstOccurrence(arr, 2);
        System.out.println("First Occurrence of 2 is at index: " + result); // Output: 1
    }
}

