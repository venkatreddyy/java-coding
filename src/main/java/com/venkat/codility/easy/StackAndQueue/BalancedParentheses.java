package com.venkat.codility.easy.StackAndQueue;

import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // If stack is empty or top is not matching, it's unbalanced
                if (stack.isEmpty() || stack.pop() != '(') return false;
            }
        }
        // If stack is empty, parentheses are balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "(())";
        boolean result = isBalanced(input);
        System.out.println("Balanced: " + result); // Output: true
    }
}

