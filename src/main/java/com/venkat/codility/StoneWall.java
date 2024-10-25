package com.venkat.codility;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;

        for (int height : H) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
                blocks++;
            }
        }

        return blocks;
    }

    public static void main(String[] args) {
        StoneWall obj = new StoneWall();
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(obj.solution(H));  // Output: 7
    }
}

