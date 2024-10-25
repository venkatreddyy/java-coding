package com.venkat.codility;

public class CaterpillarMethod {
    public boolean caterpillarMethod(int[] A, int s) {
        int front = 0, total = 0;

        for (int back = 0; back < A.length; back++) {
            while (front < A.length && total + A[front] <= s) {
                total += A[front];
                front++;
            }

            if (total == s) return true;

            total -= A[back];
        }

        return false;
    }

    public static void main(String[] args) {
        CaterpillarMethod obj = new CaterpillarMethod();
        int[] A = {6, 2, 7, 4, 1, 3, 6};
        System.out.println(obj.caterpillarMethod(A, 12));  // Output: true
    }
}

