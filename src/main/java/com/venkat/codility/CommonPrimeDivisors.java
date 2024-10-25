package com.venkat.codility;

public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                count++;
            }
        }

        return count;
    }

    private boolean hasSamePrimeDivisors(int a, int b) {
        int gcdValue = gcd(a, b);

        while (a != 1) {
            int gcdA = gcd(a, gcdValue);
            if (gcdA == 1) break;
            a /= gcdA;
        }

        if (a != 1) return false;

        while (b != 1) {
            int gcdB = gcd(b, gcdValue);
            if (gcdB == 1) break;
            b /= gcdB;
        }

        return b == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        CommonPrimeDivisors obj = new CommonPrimeDivisors();
        int[] A = {15, 10, 9};
        int[] B = {75, 30, 5};
        System.out.println(obj.solution(A, B));  // Output: 1
    }
}

