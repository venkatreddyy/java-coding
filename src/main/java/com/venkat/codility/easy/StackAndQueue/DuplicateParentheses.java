package com.venkat.codility.easy.StackAndQueue;

import java.util.Stack;

public class DuplicateParentheses {
    public static boolean hasDuplicateParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                int count = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                stack.pop(); // Pop the opening parenthesis
                // If count is zero, we have duplicate parentheses
                if (count == 0) return true;
            } else {
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "((a+b))";
        boolean result = hasDuplicateParentheses(input);
        System.out.println("Has Duplicate Parentheses: " + result); // Output: true
    }
}

