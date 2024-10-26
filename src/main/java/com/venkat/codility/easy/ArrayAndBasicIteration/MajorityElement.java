package com.venkat.codility.easy.ArrayAndBasicIteration;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        // Use Boyer-Moore Voting Algorithm to find the majority element
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int result = majorityElement(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});
        System.out.println("Majority Element: " + result); // Output: 4
    }
}

