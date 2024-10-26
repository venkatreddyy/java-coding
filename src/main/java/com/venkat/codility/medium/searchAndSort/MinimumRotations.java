package com.venkat.codility.medium.searchAndSort;

public class MinimumRotations {
    public static int findRotationCount(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            if (arr[low] <= arr[high]) return low; // Array is already sorted
            int mid = (low + high) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid; // Minimum element found at mid
            }
            if (arr[mid] <= arr[high]) high = mid - 1;
            else if (arr[mid] >= arr[low]) low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int result = findRotationCount(arr);
        System.out.println("Rotation Count: " + result); // Output: 2
    }
}

