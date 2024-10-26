package com.venkat.codility.medium.PrefixSumsCountingElements;

public class EquiLeader {
    public static int countEquiLeaders(int[] A) {
        int size = 0, value = 0;
        for (int num : A) {
            if (size == 0) {
                size++;
                value = num;
            } else if (num == value) {
                size++;
            } else {
                size--;
            }
        }

        int candidate = -1;
        if (size > 0) candidate = value;

        int count = 0;
        for (int num : A) if (num == candidate) count++;
        if (count <= A.length / 2) return 0;

        int equiLeaders = 0, leftCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) leftCount++;
            if (leftCount > (i + 1) / 2 && (count - leftCount) > (A.length - i - 1) / 2) {
                equiLeaders++;
            }
        }
        return equiLeaders;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 4, 4, 2};
        int result = countEquiLeaders(arr);
        System.out.println("Number of Equi Leaders: " + result); // Output: 2
    }
}

