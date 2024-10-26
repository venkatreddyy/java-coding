package com.venkat.codility.hard.PrefixSumsCountingElements;

public class EquiLeaderWithConstraints {

    public static int equiLeaders(int[] A, int maxSplitIndex) {
        int size = 0, candidate = -1;

        // Find candidate for the leader
        for (int num : A) {
            if (size == 0) {
                candidate = num;
                size++;
            } else if (num == candidate) {
                size++;
            } else {
                size--;
            }
        }

        // Check if candidate is actually the leader
        int count = 0;
        for (int num : A) {
            if (num == candidate) count++;
        }
        if (count <= A.length / 2) return 0;

        int equiLeaders = 0;
        int leftCount = 0;

        // Iterate through possible splits up to maxSplitIndex
        for (int i = 0; i <= Math.min(A.length - 2, maxSplitIndex); i++) {
            if (A[i] == candidate) leftCount++;
            if (leftCount > (i + 1) / 2 && (count - leftCount) > (A.length - i - 1) / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 4, 4, 4, 2};
        int maxSplitIndex = 4;
        int result = equiLeaders(A, maxSplitIndex);
        System.out.println("Number of Equi Leaders: " + result); // Output: 2
    }
}

