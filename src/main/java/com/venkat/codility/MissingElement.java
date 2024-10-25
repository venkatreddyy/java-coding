package com.venkat.codility;

public class MissingElement {
    public int solution(int[] A) {
        int N = A.length + 1;
        int totalSum = N * (N + 1) / 2;
        for (int num : A) {
            totalSum -= num;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        MissingElement obj = new MissingElement();
        int[] arr = {2, 3, 1, 5};
        System.out.println(obj.solution(arr));  // Output: 4
    }
}

