package com.venkat.dsa.patterns;

public class ContributionPatternSumOfSubstrings {

    // Function to calculate the sum of all substrings
    public static long sumOfAllSubstrings(String num) {
        int n = num.length();
        long totalSum = 0;
        long lastValue = 0;

        // Traverse through the string
        for (int i = 0; i < n; i++) {
            // Convert current digit to an integer
            int currentDigit = num.charAt(i) - '0';

            // Update last value: for each new digit, it contributes as part of new substrings
            lastValue = lastValue * 10 + (i + 1) * currentDigit;

            // Add to the total sum
            totalSum += lastValue;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        String num = "123"; // Example string
        long result = sumOfAllSubstrings(num);
        System.out.println("Sum of all substrings: " + result); // Output: 164
    }
}

