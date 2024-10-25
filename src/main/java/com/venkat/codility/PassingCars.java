package com.venkat.codility;

public class PassingCars {
    public int solution(int[] A) {
        int eastCars = 0;
        int passingCars = 0;
        for (int car : A) {
            if (car == 0) {
                eastCars++;
            } else {
                passingCars += eastCars;
                if (passingCars > 1000000000) return -1;
            }
        }
        return passingCars;
    }

    public static void main(String[] args) {
        PassingCars obj = new PassingCars();
        int[] A = {0, 1, 0, 1, 1};
        System.out.println(obj.solution(A));  // Output: 5
    }
}

