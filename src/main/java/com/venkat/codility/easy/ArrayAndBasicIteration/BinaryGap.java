package com.venkat.codility.easy.ArrayAndBasicIteration;

public class BinaryGap {
    public static int findBinaryGap(int N) {
        // Convert the integer to binary representation
        String binary = Integer.toBinaryString(N);
        // Split the binary string at each "1" to get sequences of zeros
        String[] gaps = binary.split("1");
        int maxGap = 0;
        for (int i = 0; i < gaps.length - 1; i++) {
            // Find the longest sequence of zeros
            maxGap = Math.max(maxGap, gaps[i].length());
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int result = findBinaryGap(529); // Example input
        System.out.println("Binary Gap: " + result); // Output: 4
    }
}

