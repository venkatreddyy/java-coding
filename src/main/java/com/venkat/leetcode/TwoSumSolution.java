package com.venkat.leetcode;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSumSolution {
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Indices: " + result1[0] + ", " + result1[1]); // Output: Indices: 0, 1

        // Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices: " + result2[0] + ", " + result2[1]); // Output: Indices: 1, 2

        // Example 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Indices: " + result3[0] + ", " + result3[1]); // Output: Indices: 0, 1
    }

    // Method to find the two indices whose elements sum up to the target
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the number and its index
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            // Otherwise, store the current number and its index
            numToIndex.put(nums[i], i);
        }

        // If no solution is found (shouldn't happen as per problem constraint)
        throw new IllegalArgumentException("No two sum solution");
    }
}

