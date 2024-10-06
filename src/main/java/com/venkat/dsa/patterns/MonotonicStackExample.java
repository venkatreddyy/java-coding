package com.venkat.dsa.patterns;

import java.util.Stack;

public class MonotonicStackExample {

    // Function to find the next greater element for each element in the array
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;  // Get the length of the input array
        int[] result = new int[n];  // Initialize an array to store the result (next greater elements)
        Stack<Integer> stack = new Stack<>();  // Create a stack to keep track of the elements in decreasing order

        // Traverse the array from the end to the beginning (right to left)
        for (int i = n - 1; i >= 0; i--) {

            // While the stack is not empty and the top of the stack is less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();  // Pop the top element from the stack (it is smaller and no longer needed)
            }

            // If the stack is empty, it means there is no greater element to the right
            // Otherwise, the top of the stack is the next greater element for the current element
            result[i] = stack.isEmpty() ? -1 : stack.peek();  // Store the result for the current element

            // Push the current element onto the stack for future comparisons
            stack.push(nums[i]);
        }

        // Return the array containing the next greater elements for each element
        return result;
    }

    public static void main(String[] args) {
        MonotonicStackExample example = new MonotonicStackExample();

        // Example array
        int[] nums = {2, 1, 2, 4, 3};

        // Call the function to find the next greater elements
        int[] result = example.nextGreaterElement(nums);

        // Print the result array
        for (int res : result) {
            System.out.print(res + " ");  // Output: 4 2 4 -1 -1
        }
    }
}

