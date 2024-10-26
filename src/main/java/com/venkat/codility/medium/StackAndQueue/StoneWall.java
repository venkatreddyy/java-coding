package com.venkat.codility.medium.StackAndQueue;

import java.util.Stack;

public class StoneWall {
    public static int minBlocks(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blockCount = 0;

        for (int height : H) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
                blockCount++;
            }
        }
        return blockCount;
    }

    public static void main(String[] args) {
        int[] heights = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        int result = minBlocks(heights);
        System.out.println("Minimum Blocks Needed: " + result); // Output: 7
    }
}

