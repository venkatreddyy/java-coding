package com.venkat.codility;

import java.util.Stack;

public class Nesting {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return 0;
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Nesting obj = new Nesting();
        String S = "(()(())())";
        System.out.println(obj.solution(S));  // Output: 1
    }
}

