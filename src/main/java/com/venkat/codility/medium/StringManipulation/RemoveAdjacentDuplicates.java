package com.venkat.codility.medium.StringManipulation;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // Remove adjacent duplicate
            } else {
                stack.push(c); // Add character if it's not a duplicate
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) result.append(c);
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String result = removeDuplicates(s);
        System.out.println("After Removing Adjacent Duplicates: " + result); // Output: "ca"
    }
}

