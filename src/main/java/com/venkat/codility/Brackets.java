package com.venkat.codility;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return 0;
                char open = stack.pop();
                if ((ch == ')' && open != '(') || (ch == ']' && open != '[') || (ch == '}' && open != '{')) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Brackets obj = new Brackets();
        String S = "{[()()]}";
        System.out.println(obj.solution(S));  // Output: 1
    }
}

