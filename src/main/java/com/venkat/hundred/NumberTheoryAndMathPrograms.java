package com.venkat.hundred;

import java.util.Arrays;

public class NumberTheoryAndMathPrograms {

    // 1. Fibonacci Sequence (Recursive)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;  // Base case for n = 0 or n = 1
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);  // Recursive relation
    }
    /*
    F(0) = 0
    F(1) = 1
    F(2) = F(1) + F(0) = 1
    F(3) = F(2) + F(1) = 2
    F(4) = F(3) + F(2) = 3
    F(5) = F(4) + F(3) = 5
    F(6) = F(5) + F(4) = 8
     */
    // 1. Fibonacci Sequence (Iterative)
    public static void fibonacciIterative(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");  // Print first two numbers

        for (int i = 2; i < n; i++) {
            c = a + b;  // Next number in sequence
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    // 2. Find Factorial of a Number (Recursive)
    public static int factorialRecursive(int n) {
        if (n <= 1) return 1;  // Base case
        return n * factorialRecursive(n - 1);  // Recursive step
    }

    // 2. Find Factorial of a Number (Iterative)
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;  // Multiply result by each number from 2 to n
        }
        return result;
    }

    // 3. Check if a Number is Prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;  // 1 and numbers below are not prime
        for (int i = 2; i * i <= n; i++) {  // Check divisibility up to sqrt(n)
            if (n % i == 0) return false;  // If divisible by any number, not prime
        }
        return true;  // Prime if no divisors found
    }

    // 4. Find GCD (Greatest Common Divisor) using Euclidean Algorithm
    public static int gcd(int a, int b) {
        if (b == 0) return a;  // Base case
        return gcd(b, a % b);  // Recursive step
    }

    // 4. Find LCM (Least Common Multiple)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);  // LCM formula using GCD
    }

    // 5. Check if a Number is an Armstrong Number
public static boolean isArmstrong(int n) {
    int original = n;
    int digits = 0;
    int sum = 0;
    while (n > 0) {
        digits++;
        n /= 10;
    }
    n = original;
    //n value got changes so i need to add original value to n again to get remainder
    while (n > 0) {
        int digit = n % 10;
        sum += Math.pow(digit, digits);
        n /= 10;
    }
    return sum == original;
}

    // 6. Find Sum of Digits of a Number
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;  // Add last digit to sum
            n /= 10;  // Remove last digit
        }
        return sum;
    }

    // 7. Generate Pascal’s Triangle
    public static void generatePascalsTriangle(int n) {
        for (int line = 0; line < n; line++) {
            int num = 1;  // First number in a line is always 1
            for (int i = 0; i <= line; i++) {
                System.out.print(num + " ");
                num = num * (line - i) / (i + 1);  // Calculate next number in the row
            }
            System.out.println();  // Move to the next line
        }
    }

    // 8. Check if a Number is a Perfect Square
    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);  // Take the integer part of the square root
        return sqrt * sqrt == n;  // Check if square of sqrt is equal to n
    }

    // 9. Generate Prime Numbers using Sieve of Eratosthenes
    public static void sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];  // Create a boolean array
        Arrays.fill(prime, true);  // Assume all numbers are prime initially
        prime[0] = prime[1] = false;  // 0 and 1 are not prime

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {  // If p is still prime
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;  // Mark multiples of p as not prime
                }
            }
        }

        // Print prime numbers
        System.out.print("Prime numbers up to " + n + ": ");
        for (int i = 2; i <= n; i++) {
            if (prime[i]) System.out.print(i + " ");
        }
        System.out.println();
    }

    // 10. Calculate the Power of a Number (Exponentiation)
    public static int power(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            /*
            if (exp % 2 == 1) {
    // exp is odd
}
Summary:
exp & 1 == 1: This is more efficient at the bit level since it directly checks the least significant bit.
exp % 2 == 1: This is easier to understand in plain arithmetic and checks the same condition by calculating the remainder when dividing by 2.
Both approaches give the same result, but the bitwise approach is generally faster.
             */
            if ((exp % 2) == 1) {
                result *= base;  // Multiply result by base if exponent is odd
            }
            base *= base;  // Square the base
            //exp >>= 1;
            /*
            Summary:
exp >>= 1; is more efficient because it operates directly on the bits.
exp = exp / 2; is easier to understand in terms of plain arithmetic but slightly slower in performance (though this difference is negligible for most applications).
             */
            exp =exp/ 2;  // Divide exponent by 2
        }
        return result;
    }

    public static void main(String[] args) {
        // 1. Fibonacci Sequence (Recursive and Iterative)
        System.out.println("Fibonacci (Recursive, n=6): " + fibonacciRecursive(6));  // Output: 8
        System.out.print("Fibonacci (Iterative, n=6): ");
        fibonacciIterative(6);  // Output: 0 1 1 2 3 5

        // 2. Factorial (Recursive and Iterative)
        System.out.println("\nFactorial (Recursive, n=5): " + factorialRecursive(5));  // Output: 120
        System.out.println("Factorial (Iterative, n=5): " + factorialIterative(5));  // Output: 120

        // 3. Check if a Number is Prime
        System.out.println("\nIs 29 prime? " + isPrime(29));  // Output: true
        /*
        No, 30 is not a prime number.
        A prime number has only two distinct divisors: 1 and itself. In the case of 30, it has more divisors:
        Divisors of 30: 1, 2, 3, 5, 6, 10, 15, 30.
        Since 30 is divisible by numbers other than 1 and itself, it is not a prime number.
         */
        System.out.println("Is 30 prime? " + isPrime(30));  // Output: false

        // 4. Find GCD and LCM of Two Numbers
        /*
        Divisors of 12: 1, 2, 3, 4, 6, 12
        Divisors of 18: 1, 2, 3, 6, 9, 18
        The common divisors of 12 and 18 are: 1, 2, 3, and 6.
        Thus, the GCD of 12 and 18 is 6.
         */
        System.out.println("\nGCD of 12 and 18: " + gcd(12, 18));  // Output: 6
        /*
        LCM(12,18)= 36
(12×18)/6=216/6=36

Thus, LCM of 12 and 18 is 36.
         */
        System.out.println("LCM of 12 and 18: " + lcm(12, 18));  // Output: 36

        // 5. Check if a Number is an Armstrong Number
        /*

         */
        System.out.println("\nIs 153 an Armstrong number? " + isArmstrong(153));  // Output: true
        System.out.println("Is 123 an Armstrong number? " + isArmstrong(123));  // Output: false

        // 6. Find Sum of Digits of a Number
        System.out.println("\nSum of digits of 1234: " + sumOfDigits(1234));  // Output: 10

        // 7. Generate Pascal’s Triangle
        System.out.println("\nPascal's Triangle (n=5):");
        generatePascalsTriangle(5);  // Output: Pascal's triangle of 5 rows

        // 8. Check if a Number is a Perfect Square
        System.out.println("\nIs 25 a perfect square? " + isPerfectSquare(25));  // Output: true
        System.out.println("Is 26 a perfect square? " + isPerfectSquare(26));  // Output: false

        // 9. Generate Prime Numbers using Sieve of Eratosthenes
        sieveOfEratosthenes(30);  // Output: Prime numbers up to 30

        // 10. Calculate the Power of a Number
        System.out.println("\nPower (2^10): " + power(2, 10));  // Output: 1024
    }
}

