package com.venkat.codility;

public class EquiLeader {
    public int solution(int[] A) {
        int candidate = findCandidate(A);
        if (candidate == -1) return 0;

        int leaderCount = 0;
        for (int num : A) {
            if (num == candidate) leaderCount++;
        }

        if (leaderCount <= A.length / 2) return 0;

        int equiLeaders = 0;
        int leftLeaderCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) leftLeaderCount++;
            if (leftLeaderCount > (i + 1) / 2 && leaderCount - leftLeaderCount > (A.length - i - 1) / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }

    private int findCandidate(int[] A) {
        int size = 0;
        int value = 0;
        for (int num : A) {
            if (size == 0) {
                size++;
                value = num;
            } else {
                if (value != num) {
                    size--;
                } else {
                    size++;
                }
            }
        }

        int candidate = -1;
        if (size > 0) candidate = value;
        return candidate;
    }

    public static void main(String[] args) {
        EquiLeader obj = new EquiLeader();
        int[] A = {4, 3, 4, 4, 4, 2};
        System.out.println(obj.solution(A));  // Output: 2
    }
}

