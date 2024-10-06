package com.venkat.hundred;

import java.util.*;
/*
Explanation of Each Problem and Test Cases:
Find the Missing Number: Finds the missing number in an array containing numbers from 1 to n.

Output: 3
Find Second Largest Element: Finds the second-largest element in an array.

Output: 10
Find Common Elements in Three Sorted Arrays: Finds common elements across three sorted arrays.

Output: [5, 10]
Find the Transition Point in a Binary Array: Finds the transition point (first occurrence of '1') in a binary array.

Output: 3
Floor in a Sorted Array: Finds the largest element smaller than or equal to a given value.

Output: 2
Find a Pair with the Given Difference: Finds if there is a pair of elements with the given difference.

Output: true
Square Root of an Integer: Finds the integer part of the square root of a given number.

Output: 4
Find the Rotation Count in a Rotated Sorted Array: Finds the number of rotations in a rotated sorted array.

Output: 2
Search in a Row-Wise and Column-Wise Sorted Matrix: Searches for an element in a matrix that is sorted both row-wise and column-wise.

Output: true
Find the Maximum Element in a Bitonic Array: Finds the maximum element in an array that first increases and then decreases.

Output: 12
 */
public class Level1SearchingProblems {

    // 1. Find the Missing Number (from an array containing numbers 1 to n)
    // Time Complexity: O(n), where n is the number of elements in the array
    // Space Complexity: O(1), no extra space used
    public static int findMissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2; // Sum of numbers from 1 to n
        int actualSum = 0; // Sum of array elements
        for (int num : arr) {
            actualSum += num;
        }
        return totalSum - actualSum; // Missing number is the difference between expected and actual sums
    }

    // 2. Find Second Largest Element in an Array
    // Time Complexity: O(n), where n is the number of elements in the array
    // Space Complexity: O(1), no extra space used
    public static int findSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE; // Initialize first and second largest
        for (int num : arr) {
            if (num > first) { // If current number is greater than first, update first and second
                second = first;
                first = num;
            } else if (num > second && num != first) { // Update second if current number is less than first but greater than second
                second = num;
            }
        }
        return second; // Return second largest
    }

    // 3. Find Common Elements in Three Sorted Arrays
    // Time Complexity: O(n1 + n2 + n3), where n1, n2, and n3 are the sizes of the three arrays
    // Space Complexity: O(1), no extra space used
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0; // Pointers for arr1, arr2, and arr3

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) { // If elements match, add to result
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) { // Move the pointer of the smallest element
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result; // Return the list of common elements
    }

    // 4. Find the Transition Point in a Binary Array (first '1' in a sorted binary array)
    // Time Complexity: O(log n), where n is the number of elements in the array
    // Space Complexity: O(1), no extra space used
    public static int findTransitionPoint(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) return mid; // First '1'
            else if (arr[mid] == 0) low = mid + 1; // Move right if mid is 0
            else high = mid - 1; // Move left if mid is 1 but not the first
        }
        return -1; // No '1' found
    }

    // 5. Floor in a Sorted Array (largest element smaller than or equal to x)
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

    // 6. Find a Pair with the Given Difference
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

    // 7. Square Root of an Integer (without using sqrt function)
    // Time Complexity: O(log n), where n is the integer
    // Space Complexity: O(1), no extra space used
    public static int squareRoot(int n) {
        if (n == 0 || n == 1) return n;
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= n / mid) { // Check if mid*mid <= n
                ans = mid; // Update answer
                low = mid + 1; // Move right to find larger answer
            } else {
                high = mid - 1; // Move left to find smaller answer
            }
        }
        return ans; // Return the floor of the square root
    }

    // 8. Find the Rotation Count in a Rotated Sorted Array
    // Time Complexity: O(log n), where n is the number of elements in the array
    // Space Complexity: O(1), no extra space used
    public static int findRotationCount(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            if (arr[low] <= arr[high]) return low; // Already sorted, no rotation
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) return mid; // Found the rotation point
            else if (arr[mid] >= arr[low]) low = mid + 1; // Move right
            else high = mid - 1; // Move left
        }
        return -1; // Not a rotated sorted array
    }

    // 9. Search in a Row-Wise and Column-Wise Sorted Matrix
    // Time Complexity: O(n + m), where n is the number of rows and m is the number of columns
    // Space Complexity: O(1), no extra space used
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true; // Target found
            else if (matrix[row][col] > target) col--; // Move left
            else row++; // Move down
        }
        return false; // Target not found
    }

    // 10. Find the Maximum Element in an Array which is First Increasing and then Decreasing
    // Time Complexity: O(log n), where n is the number of elements in the array
    // Space Complexity: O(1), no extra space used
    public static int findMaximumInBitonicArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid; // Found the peak element
                else if (arr[mid - 1] > arr[mid]) high = mid - 1; // Move left
                else low = mid + 1; // Move right
            } else if (mid == 0) return (arr[0] > arr[1]) ? 0 : 1; // Handle corner case for first element
            else return (arr[arr.length - 1] > arr[arr.length - 2]) ? arr.length - 1 : arr.length - 2; // Handle corner case for last element
        }
        return -1; // No peak found
    }

    // Main method to test all the functions
    public static void main(String[] args) {
        // 1. Test Find the Missing Number
        int[] arr1 = {1, 2, 4, 5, 6};
        System.out.println("Missing Number: " + findMissingNumber(arr1, 6)); // Expected: 3

        // 2. Test Find Second Largest Element
        int[] arr2 = {10, 5, 20, 8};
        System.out.println("Second Largest Element: " + findSecondLargest(arr2)); // Expected: 10

        // 3. Test Find Common Elements in Three Sorted Arrays
        int[] arr3_1 = {1, 5, 10, 20};
        int[] arr3_2 = {5, 10, 30, 40};
        int[] arr3_3 = {5, 10, 20, 40};
        System.out.println("Common Elements: " + findCommonElements(arr3_1, arr3_2, arr3_3)); // Expected: [5, 10]

        // 4. Test Find the Transition Point
        int[] arr4 = {0, 0, 0, 1, 1};
        System.out.println("Transition Point: " + findTransitionPoint(arr4)); // Expected: 3

        // 5. Test Floor in a Sorted Array
        int[] arr5 = {1, 2, 8, 10, 12, 14, 19};
        System.out.println("Floor of 5: " + findFloor(arr5, 5)); // Expected: 1 (index 2, value 2)

        // 6. Test Find a Pair with the Given Difference
        int[] arr6 = {1, 8, 30, 40, 100};
        System.out.println("Pair with difference 60: " + findPairWithDifference(arr6, 60)); // Expected: true

        // 7. Test Square Root of an Integer
        System.out.println("Square Root of 17: " + squareRoot(17)); // Expected: 4

        // 8. Test Find the Rotation Count in a Rotated Sorted Array
        int[] arr8 = {15, 18, 2, 3, 6, 12};
        System.out.println("Rotation Count: " + findRotationCount(arr8)); // Expected: 2

        // 9. Test Search in a Row-Wise and Column-Wise Sorted Matrix
        int[][] matrix9 = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println("Search 29 in matrix: " + searchMatrix(matrix9, 29)); // Expected: true

        // 10. Test Find Maximum in a Bitonic Array
        int[] arr10 = {1, 3, 8, 12, 4, 2};
        System.out.println("Maximum in Bitonic Array: " + arr10[findMaximumInBitonicArray(arr10)]); // Expected: 12
    }
}
