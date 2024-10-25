package com.venkat.codility;

public class CountDiv {
    public int solution(int A, int B, int K) {
        return (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        CountDiv obj = new CountDiv();
        System.out.println(obj.solution(6, 11, 2));  // Output: 3
    }
}

