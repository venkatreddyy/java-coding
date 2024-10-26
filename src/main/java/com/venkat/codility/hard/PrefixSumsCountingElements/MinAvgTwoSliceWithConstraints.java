package com.venkat.codility.hard.PrefixSumsCountingElements;

public class MinAvgTwoSliceWithConstraints {
    public static int minAvgTwoSlice(int[] A, int maxStartIndex) {
        double minAvg = (A[0] + A[1]) / 2.0;
        int minStart = 0;

        for (int i = 0; i < Math.min(A.length - 2, maxStartIndex); i++) {
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;

            if (avg2 < minAvg) {
                minAvg = avg2;
                minStart = i;
            }
            if (avg3 < minAvg) {
                minAvg = avg3;
                minStart = i;
            }
        }

        // Check the last 2-element slice if within constraint
        if (maxStartIndex >= A.length - 2) {
            double lastAvg = (A[A.length - 2] + A[A.length - 1]) / 2.0;
            if (lastAvg < minAvg) minStart = A.length - 2;
        }

        return minStart;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        int maxStartIndex = 4;
        int result = minAvgTwoSlice(A, maxStartIndex);
        System.out.println("MinAvgTwoSlice Starting Position: " + result); // Output: 1
    }
}

