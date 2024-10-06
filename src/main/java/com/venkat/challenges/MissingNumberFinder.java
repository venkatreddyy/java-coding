package com.venkat.challenges;

/*
Time Complexity:
O(n), where
𝑛
n is the number of elements in the array. This is because we need to iterate over the array once to calculate the actual sum.
Space Complexity:
O(1), since we only use a few variables to store the sum and the result.
 */
public class MissingNumberFinder {

    // Method to find the missing number in the array
    public static int findMissingNumber(int[] arr, int n) {
        // Calculate the expected sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;
        System.out.println("expectedSum: "+expectedSum);

        // Calculate the actual sum of elements in the array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // The missing number is the difference between expectedSum and actualSum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // Example array with numbers from 1 to 100, but one number is missing
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 100};  // Missing number 99

        // Find and print the missing number
        int missingNumber = findMissingNumber(arr, 100);
        System.out.println("The missing number is: " + missingNumber);
    }
}
