package com.venkat.codility;

public class CountFactors {
    public int solution(int N) {
        int factors = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                factors += (i * i == N) ? 1 : 2;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        CountFactors obj = new CountFactors();
        System.out.println(obj.solution(24));  // Output: 8
    }
}

