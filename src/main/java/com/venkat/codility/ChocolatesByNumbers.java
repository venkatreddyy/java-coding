package com.venkat.codility;

public class ChocolatesByNumbers {
    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        ChocolatesByNumbers obj = new ChocolatesByNumbers();
        System.out.println(obj.solution(10, 4));  // Output: 5
    }
}

