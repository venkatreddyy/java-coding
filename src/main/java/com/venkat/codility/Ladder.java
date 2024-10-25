package com.venkat.codility;

import java.util.Arrays;

public class Ladder {
    public int[] solution(int[] A, int[] B) {
        int L = A.length;
        int[] result = new int[L];

        int maxA = Arrays.stream(A).max().getAsInt();
        int maxB = Arrays.stream(B).max().getAsInt();
        int[] fib = new int[maxA + 2];

        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= maxA + 1; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % (1 << maxB);
        }

        for (int i = 0; i < L; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Ladder obj = new Ladder();
        int[] A = {4, 4, 5, 5, 1};
        int[] B = {3, 2, 4, 3, 1};
        int[] result = obj.solution(A, B);
        for (int r : result) {
            System.out.print(r + " ");  // Output: 5 1 8 0 1
        }
    }
}

