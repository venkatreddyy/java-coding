package com.venkat.codility.easy.ArrayAndBasicIteration;

public class CyclicRotation {
    public static int[] rotateArray(int[] A, int K) {
        int n = A.length;
        int[] rotated = new int[n];
        // Rotate each element to the right by K steps
        for (int i = 0; i < n; i++) {
            rotated[(i + K) % n] = A[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] result = rotateArray(new int[]{3, 8, 9, 7, 6}, 3);
        System.out.println("Rotated Array: " + java.util.Arrays.toString(result));
    }
}

