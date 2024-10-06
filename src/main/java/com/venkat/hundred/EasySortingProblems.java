package com.venkat.hundred;

import java.util.*;

public class EasySortingProblems {

    // 1. Check if a given array contains duplicate elements within k distance from each other
    // Time Complexity: O(n), where n is the number of elements in the array
    // Space Complexity: O(k), for the sliding window set
    public static boolean containsDuplicateWithinK(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) return true; // Duplicate found within k distance
            set.add(arr[i]);
            if (set.size() > k) set.remove(arr[i - k]); // Maintain the sliding window of size k
        }
        return false; // No duplicate found within k distance
    }

    // 2. Check whether two Strings are anagrams of each other
    // Time Complexity: O(n log n), where n is the length of the strings (due to sorting)
    // Space Complexity: O(1), since sorting is in-place
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Anagrams must be of the same length
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1); // Sort both strings
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2); // Compare sorted versions of both strings
    }

    // 3. Maximum Perimeter Triangle from array
    // Time Complexity: O(n log n), where n is the number of elements in the array (due to sorting)
    // Space Complexity: O(1), no extra space used
    public static int maximumPerimeterTriangle(int[] arr) {
        Arrays.sort(arr); // Sort the array
        for (int i = arr.length - 1; i >= 2; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) { // Check if the three sides form a valid triangle
                return arr[i] + arr[i - 1] + arr[i - 2]; // Return the perimeter of the triangle
            }
        }
        return -1; // No valid triangle can be formed
    }

    // 4. Maximize array sum after K negations using Sorting
    // Time Complexity: O(n log n), where n is the number of elements in the array (due to sorting)
    // Space Complexity: O(1), no extra space used
    public static int maximizeArraySumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr); // Sort the array
        for (int i = 0; i < arr.length && k > 0; i++) {
            if (arr[i] < 0) { // Negate negative numbers
                arr[i] = -arr[i];
                k--;
            }
        }
        if (k % 2 == 1) { // If k is odd, negate the smallest positive number
            Arrays.sort(arr); // Re-sort to bring smallest element to the front
            arr[0] = -arr[0];
        }
        return Arrays.stream(arr).sum(); // Return the sum of the modified array
    }

    // 5. Sum of minimum absolute difference of each array element
    // Time Complexity: O(n log n), where n is the number of elements in the array (due to sorting)
    // Space Complexity: O(1), no extra space used
    public static int sumOfMinAbsoluteDifference(int[] arr) {
        Arrays.sort(arr); // Sort the array
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i + 1] - arr[i]); // Add absolute differences of adjacent elements
        }
        return sum; // Return the total sum of minimum absolute differences
    }

    // 6. Sort an array in waveform (arr[0] >= arr[1] <= arr[2] >= arr[3]...)
    // Time Complexity: O(n log n), where n is the number of elements in the array (due to sorting)
    // Space Complexity: O(1), no extra space used
    public static void sortInWaveform(int[] arr) {
        Arrays.sort(arr); // Sort the array
        for (int i = 0; i < arr.length - 1; i += 2) {
            // Swap adjacent elements to create waveform pattern
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    // 7. Chocolate Distribution Problem (Distribute chocolates such that the difference between max and min chocolates is minimized)
    // Time Complexity: O(n log n), where n is the number of elements in the array (due to sorting)
    // Space Complexity: O(1), no extra space used
    public static int chocolateDistribution(int[] arr, int m) {
        if (m > arr.length) return -1; // More students than chocolates, invalid case
        Arrays.sort(arr); // Sort the array
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - m; i++) {
            int diff = arr[i + m - 1] - arr[i]; // Calculate the difference between max and min chocolates in the current window
            minDifference = Math.min(minDifference, diff);
        }
        return minDifference; // Return the minimum difference
    }

    // 8. Floor in a Sorted Array (Reimplemented from earlier for completeness)
    // Time Complexity: O(log n), where n is the number of elements in the array
    // Space Complexity: O(1), no extra space used
    public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1, floor = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) return mid; // Exact match
            else if (arr[mid] < x) {
                floor = mid; // Update floor
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        return floor; // Return floor index
    }

    // 9. Find a Pair with the Given Difference (Reimplemented from earlier for completeness)
    // Time Complexity: O(n log n), where n is the number of elements in the array (due to sorting)
    // Space Complexity: O(1), no extra space used
    public static boolean findPairWithDifference(int[] arr, int diff) {
        Arrays.sort(arr); // Sort the array
        int left = 0, right = 1;

        while (right < arr.length) {
            int currentDiff = arr[right] - arr[left];
            if (currentDiff == diff) return true; // Pair found
            else if (currentDiff < diff) right++; // Increase right pointer
            else left++; // Increase left pointer
        }
        return false; // No pair found
    }

    // Main method to test all the functions
    public static void main(String[] args) {
        // 1. Test Check if a given array contains duplicate elements within k distance
        int[] arr1 = {1, 2, 3, 1, 4, 5};
        System.out.println("Contains Duplicate within K Distance: " + containsDuplicateWithinK(arr1, 3)); // Expected: true

        // 2. Test Check whether two Strings are anagrams
        System.out.println("Are 'listen' and 'silent' Anagrams? " + areAnagrams("listen", "silent")); // Expected: true

        // 3. Test Maximum Perimeter Triangle
        int[] arr2 = {6, 4, 9, 7, 8};
        System.out.println("Maximum Perimeter Triangle: " + maximumPerimeterTriangle(arr2)); // Expected: 24

        // 4. Test Maximize Array Sum after K Negations
        int[] arr3 = {-2, 0, 5, -1, 2};
        System.out.println("Maximized Sum after K Negations: " + maximizeArraySumAfterKNegations(arr3, 4)); // Expected: 10

        // 5. Test Sum of Minimum Absolute Differences
        int[] arr4 = {1, 3, 6, 19, 20};
        System.out.println("Sum of Minimum Absolute Differences: " + sumOfMinAbsoluteDifference(arr4)); // Expected: 19

        // 6. Test Sort an Array in Waveform
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        sortInWaveform(arr5);
        System.out.println("Waveform Sorted Array: " + Arrays.toString(arr5)); // Expected: [2, 1, 4, 3, 6, 5]

        // 7. Test Chocolate Distribution Problem
        int[] arr6 = {12, 4,
                7, 9, 2, 23, 25, 41, 30, 40, 28};
        System.out.println("Chocolate Distribution Minimum Difference: " + chocolateDistribution(arr6, 5)); // Expected: 6

        // 8. Test Floor in a Sorted Array
        int[] arr7 = {1, 2, 8, 10, 12, 14, 19};
        System.out.println("Floor of 5: " + findFloor(arr7, 5)); // Expected: 1 (index 2, value 2)

        // 9. Test Find a Pair with the Given Difference
        int[] arr8 = {1, 8, 30, 40, 100};
        System.out.println("Pair with difference 60: " + findPairWithDifference(arr8, 60)); // Expected: true
    }
}

