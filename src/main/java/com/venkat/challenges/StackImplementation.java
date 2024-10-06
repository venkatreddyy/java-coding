package com.venkat.challenges;

import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);  // Output: Stack: [1, 2, 3]
        System.out.println("Popped element: " + stack.pop());  // Output: 3
        System.out.println("Peek element: " + stack.peek());   // Output: 2
    }
}

