package com.venkat.dsa.patterns;
/*
Modified Binary Search
Modified Binary Search refers to variations of the standard Binary Search algorithm, adapted to solve more complex problems that involve searching within a sorted or partially sorted array.

One common application of a modified binary search is finding an element in a rotated sorted array. In a rotated sorted array, the array was originally sorted but then rotated at some pivot point. For example, the array [4, 5, 6, 7, 0, 1, 2] is a rotated version of [0, 1, 2, 4, 5, 6, 7]. A regular binary search won’t work on such arrays because the sorting order is disrupted.

Problem Statement:
Given a rotated sorted array, find a target element.

Example:
Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
Output: 4 (index of the target)
Approach:
We can still apply a modified binary search by determining which part of the array (left or right of the middle element) is sorted and then deciding whether the target lies in the sorted half or not. Here's the plan:

Divide the array: Find the middle element.
Check which side is sorted:
If the left part is sorted, check if the target is within the left part. If it is, search there.
If the right part is sorted, check if the target is within the right part. If it is, search there.
Repeat: Continue this process until the element is found or the search space is exhausted.

Time Complexity:
O(log n): Like traditional binary search, we are halving the search space each time, resulting in a logarithmic time complexity.
Example Walkthrough:
For the array nums = [4, 5, 6, 7, 0, 1, 2] and target 0:

Initially, left = 0, right = 6, mid = 3 (element 7):

7 is not the target.
The left side [4, 5, 6, 7] is sorted.
Since 0 is not in this range, we search in the right half.
Now, left = 4, right = 6, mid = 5 (element 1):

1 is not the target.
The right side [0, 1, 2] is sorted.
The target 0 is in this range, so we continue searching in the left half.
Finally, left = 4, right = 4, mid = 4 (element 0):

0 is the target, return the index 4.
Edge Cases:
Array is not rotated: The algorithm still works since it defaults to a normal binary search.
Target not in the array: The algorithm returns -1 if the target is not found.
Empty array: If nums.length == 0, return -1 immediately.

 */
public class ModifiedBinarySearch {

    // Method to search for the target in a rotated sorted array
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // Find the middle index

            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}

