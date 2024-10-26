package com.venkat.codility.medium.StackAndQueue;

import java.util.Stack;

public class BracketMatching {
    public static boolean isMatching(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((ch == ')' && open != '(') || (ch == ']' && open != '[') || (ch == '}' && open != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{[()()]}";
        boolean result = isMatching(input);
        System.out.println("Is Matching: " + result); // Output: true
    }
}

