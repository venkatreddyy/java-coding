package com.venkat.challenges;

public class PermMissingElements {

    public static void main(String[] args) {
        int[] A = new int[]{2,3,1,5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int[] counters = new int[A.length+2];
        for (int i = 0; i < A.length; i++) {
            counters[A[i]] = 1;
        }
        for (int i = 1; i < counters.length; i++) {
            if (counters[i] == 0)
                return i;
        }
        //no element is missing
        return -1;
    }
}
