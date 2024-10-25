package com.venkat.codility;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        if (N == 0) return A;
        K = K % N;
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[(i + K) % N] = A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        CyclicRotation obj = new CyclicRotation();
        int[] arr = {3, 8, 9, 7, 6};
        int[] rotatedArr = obj.solution(arr, 3);
        for (int i : rotatedArr) {
            System.out.print(i + " ");  // Output: 9 7 6 3 8
        }
    }
}

