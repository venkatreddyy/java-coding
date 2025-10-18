package com.venkat.challenges.apple;

import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        // 🔹 isEmpty() before push
        System.out.println("isEmpty before push(): " + stack.isEmpty()); // true

        // 🔹 push(E e)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After push(10, 20, 30): " + stack); // [30, 20, 10]

        // 🔹 peek()
        System.out.println("peek(): " + stack.peek()); // 30
        System.out.println("After peek(): " + stack);  // [30, 20, 10] (unchanged)

        // 🔹 pop()
        int removed = stack.pop();
        System.out.println("pop(): " + removed);       // 30
        System.out.println("After pop(): " + stack);   // [20, 10]

        // 🔹 isEmpty() after operations
        System.out.println("isEmpty after pop(): " + stack.isEmpty()); // false
    }
}
