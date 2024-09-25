package com.venkat.codility;

public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] A = new int[]{3,1,2,4,3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int res = Integer.MAX_VALUE;
        int tmp=0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        for (int i = 0; i < A.length-1; i++) {
            tmp+=A[i];
            res = Math.min(res, Math.abs(tmp - (sum - tmp)));
        }
        return res;
    }
}