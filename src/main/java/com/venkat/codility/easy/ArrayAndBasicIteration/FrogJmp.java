package com.venkat.codility.easy.ArrayAndBasicIteration;

public class FrogJmp {
    public static int frogJump(int X, int Y, int D) {
        // Calculate the minimal number of jumps needed
        return (int) Math.ceil((double)(Y - X) / D);
    }

    public static void main(String[] args) {
        int result = frogJump(10, 85, 30);
        System.out.println("Minimal Jumps: " + result); // Output: 3
    }
}

