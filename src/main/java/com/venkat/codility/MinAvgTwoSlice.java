package com.venkat.codility;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int minPos = 0;
        double minAvg = (A[0] + A[1]) / 2.0;  // Initialize with first 2-element slice

        for (int i = 0; i < A.length - 2; i++) {
            // Check 2-element slice
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minPos = i;
            }
            // Check 3-element slice
            double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
            if (avg3 < minAvg) {
                minAvg = avg3;
                minPos = i;
            }
        }
        // Check the last 2-element slice
        double avg2 = (A[A.length - 2] + A[A.length - 1]) / 2.0;
        if (avg2 < minAvg) {
            minAvg = avg2;
            minPos = A.length - 2;
        }

        return minPos;
    }

    public static void main(String[] args) {
        MinAvgTwoSlice obj = new MinAvgTwoSlice();
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(obj.solution(A));  // Output: 1
    }
}

