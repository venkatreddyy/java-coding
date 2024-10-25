package com.venkat.codility;

public class MinPerimeterRectangle {
    public int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                int perimeter = 2 * (i + N / i);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }

    public static void main(String[] args) {
        MinPerimeterRectangle obj = new MinPerimeterRectangle();
        System.out.println(obj.solution(30));  // Output: 22
    }
}

