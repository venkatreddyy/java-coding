package com.venkat.codility.medium.StackAndQueue;

public class Dominator {
    public static int findDominatorIndex(int[] A) {
        int size = 0, value = -1;

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
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
                index = i;
            }
        }
        return count > A.length / 2 ? index : -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 2, 3, -1, 3, 3};
        int result = findDominatorIndex(arr);
        System.out.println("Dominator Index: " + result); // Output: 0 (or any valid index of 3)
    }
}

