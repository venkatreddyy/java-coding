package com.venkat.challenges;

public class Test1 {

    public static int solution(int[] A) {
        int n = A.length;
        if (n == 0) return 0;

        int[] LIS = new int[n]; // Array to store lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;  // Initialize all LIS values as 1
        }

        // Calculate LIS with the constraint that adjacent elements must differ by at least 1
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && A[i] - A[j] >= 1) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, LIS[i]);  // Track the maximum LIS length
        }

        // The minimum number of changes needed to make the array strictly increasing
        int changesNeeded = n - maxLen;

        return changesNeeded;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 1, 3, 5};
        int n = arr.length;
        System.out.println("Minimum removals to make array strictly increasing: " + solution(arr));
    }
}

