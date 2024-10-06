package com.venkat.challenges;

public class PrimeNumberCheck {

    // Method to check if a given number is prime
    public static boolean isPrime(int n) {
        // Handle base cases: numbers less than or equal to 1 are not prime
        if (n <= 1) return false;

        // Loop from 2 to the square root of 'n'
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // If 'n' is divisible by any number between 2 and sqrt(n), it is not prime
            if (n % i == 0) return false;
        }

        // If no divisor was found, the number is prime
        return true;
    }

    // Main method to test the isPrime function
    public static void main(String[] args) {
        // Test with the number 7 (a prime number)
        System.out.println(isPrime(7));  // Output: true

        // Test with the number 10 (not a prime number)
        System.out.println(isPrime(10)); // Output: false
    }
}


