package com.venkat.codility;

public class PairwiseProductSum {
    public int solution(int[] A) {
        int sum = 0;
        int totalSum = 0;

        for (int num : A) {
            totalSum += num;
        }

        for (int num : A) {
            totalSum -= num;
            sum += num * totalSum;
        }

        return sum;
    }

    public static void main(String[] args) {
        PairwiseProductSum obj = new PairwiseProductSum();
        int[] A = {1, 3, 5};
        System.out.println(obj.solution(A));  // Output: 23
    }
}

