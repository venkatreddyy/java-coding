package com.venkat.codility.medium.PrefixSumsCountingElements;

public class MinAvgTwoSlice {
    public static int findMinAvgSlice(int[] A) {
        int minIndex = 0;
        double minAvg = (A[0] + A[1]) / 2.0;

        for (int i = 0; i < A.length - 2; i++) {
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;

            if (avg2 < minAvg) {
                minAvg = avg2;
                minIndex = i;
            }
            if (avg3 < minAvg) {
                minAvg = avg3;
                minIndex = i;
            }
        }
        if ((A[A.length - 2] + A[A.length - 1]) / 2.0 < minAvg) {
            minIndex = A.length - 2;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 5, 1, 5, 8};
        int result = findMinAvgSlice(arr);
        System.out.println("Starting Index of Min Avg Slice: " + result); // Output: 1
    }
}

