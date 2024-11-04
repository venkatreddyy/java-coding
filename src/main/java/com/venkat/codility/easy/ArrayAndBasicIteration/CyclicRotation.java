package com.venkat.codility.easy.ArrayAndBasicIteration;
/*
The Cyclic Rotation problem involves rotating an array to the right by a given number of steps. Here’s a breakdown of the approach:

Problem Breakdown
Goal: Shift each element in the array to the right by K positions.
Handling K Greater Than Array Length:
If K is greater than the array length N, rotating K times is equivalent to rotating K % N times, as a full rotation brings the array back to its original position.
Approach
Calculate Effective Rotations: Set K = K % N to handle cases where K is greater than the array length.
Use Slicing to Rotate:
Split the array into two parts:
The last K elements.
The first N - K elements.
Concatenate these parts in reverse order to achieve the rotation.



 */
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

    /*
int[] A = {1, 2, 3, 4, 5};
int K = 2; // Rotate by 2 positions
First Step: System.arraycopy(A, 3, rotatedArray, 0, 2);

This copies {4, 5} to the start of rotatedArray.
Second Step: System.arraycopy(A, 0, rotatedArray, 2, 3);

This copies {1, 2, 3} to follow {4, 5} in rotatedArray.


     */
    public static int[] rotate(int[] A, int K) {
        int N = A.length;
        if (N == 0 || K % N == 0) return A; // No rotation needed

        K = K % N; // Effective rotations
        int[] rotatedArray = new int[N];

        // Split and concatenate
        System.arraycopy(A, N - K, rotatedArray, 0, K); // Last K elements to the front
        System.arraycopy(A, 0, rotatedArray, K, N - K); // First N-K elements after them

        return rotatedArray;
    }

    public static void main(String[] args) {
        int[] result = rotateArray(new int[]{3, 8, 9, 7, 6}, 3);
        System.out.println("Rotated Array: " + java.util.Arrays.toString(result));//Rotated Array: [9, 7, 6, 3, 8]


        int[] result1 = rotate(new int[]{3, 8, 9, 7, 6}, 3);
        System.out.println("Rotated Array: " + java.util.Arrays.toString(result1));//Rotated Array: [9, 7, 6, 3, 8]

    }
}

