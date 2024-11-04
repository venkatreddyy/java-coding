package com.venkat.codility.easy.ArrayAndBasicIteration;

public class PassingCars {
    public static int passingCars(int[] A) {
        int countZero = 0, pairs = 0;
        // Track pairs of cars passing in opposite directions
        for (int car : A) {
            if (car == 0)
                countZero++;
            else pairs +=
                    countZero;
            if (pairs > 1_000_000_000) return -1;
        }
        return pairs;
    }

    public static void main(String[] args) {
        int result = passingCars(new int[]{0, 1, 0, 1, 1});
        System.out.println("Passing Car Pairs: " + result); // Output: 5
    }
}

