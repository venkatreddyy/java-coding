package com.venkat.programs.basic;

import java.util.Random;
/*
Detailed Explanation and Time/Space Complexities:
Fibonacci Series: O(n) time, O(1) space.
Prime Number Check: O(√n) time, O(1) space.
Palindrome Check: O(n) time, O(n) space.
Factorial: O(n) time, O(n) space (recursion depth).
Armstrong Number Check: O(d) time, O(1) space (where d is the number of digits).
Random Number Generation: O(1) time, O(1) space.
Pattern Printing: O(rows^2) time, O(1) space.
Object Comparison: O(1) time, O(1
 */
public class BasicProgramsJava17 {

    // 1) Fibonacci Series in Java
    // Uses basic loop constructs available since Java 1.0
    public static void printFibonacci(int n) {
        int a = 0, b = 1; // Initialize the first two Fibonacci numbers
        System.out.print("Fibonacci Series: " + a + " " + b); // Print the first two numbers
        for (int i = 2; i < n; i++) { // Loop starts from the 3rd number
            int next = a + b; // Calculate the next Fibonacci number
            System.out.print(" " + next); // Print the next number
            a = b; // Shift the previous value of 'b' to 'a'
            b = next; // Assign the next Fibonacci number to 'b'
        }
        System.out.println(); // Print a new line at the end
    }
    // Time Complexity: O(n) — where `n` is the number of Fibonacci terms to generate.
    // Space Complexity: O(1) — constant space since only a few variables are used.

    // 2) Prime Number Program in Java
    // Uses basic loops and math, available since Java 1.0
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        // Loop from 2 to sqrt(num) to check for divisibility
        for (int i = 2; i <= Math.sqrt(num); i++) { // Math.sqrt() available since Java 1.0
            if (num % i == 0) { // If divisible by any number other than 1 and itself, it's not prime
                return false;
            }
        }
        return true; // If no divisor is found, it's a prime number
    }
    // Time Complexity: O(√n) — only checks up to the square root of the number.
    // Space Complexity: O(1) — constant space for a few variables.

    // 3) Palindrome Program in Java
    // StringBuilder introduced in Java 1.5
    public static boolean isPalindrome(String str) {
        // Reverse the string using StringBuilder and compare it with the original string
        String reversed = new StringBuilder(str).reverse().toString(); // StringBuilder.reverse() since Java 1.5
        return str.equals(reversed); // Return true if the reversed string equals the original string
    }
    // Time Complexity: O(n) — where `n` is the length of the string (to reverse and compare).
    // Space Complexity: O(n) — additional space for storing the reversed string.

    // 4) Factorial Program in Java
    // Uses recursion, available since Java 1.0
    public static int factorial(int n) {
        if (n == 0 || n == 1) { // Base case: factorial(0) = factorial(1) = 1
            return 1;
        }
        return n * factorial(n - 1); // Recursive call: n * factorial(n-1)
    }
    // Time Complexity: O(n) — where `n` is the input number (due to recursion depth).
    // Space Complexity: O(n) — space required for the recursive call stack.

    // 5) Armstrong Number in Java
    // Math.pow() available since Java 1.0
    public static boolean isArmstrong(int num) {
        int original = num, sum = 0, digits = String.valueOf(num).length(); // Calculate the number of digits
        while (num > 0) {
            int digit = num % 10; // Extract the last digit of the number
            sum += Math.pow(digit, digits); // Raise the digit to the power of the number of digits and add to sum
            num /= 10; // Remove the last digit from the number
        }
        return sum == original; // Return true if the sum equals the original number
    }
    // Time Complexity: O(d) — where `d` is the number of digits in the number.
    // Space Complexity: O(1) — constant space for a few variables.

    // 6) How to Generate Random Number in Java
    // Random class introduced in Java 1.0, nextInt() since Java 1.2
    public static int generateRandomNumber(int bound) {
        Random random = new Random(); // Create an instance of the Random class
        return random.nextInt(bound); // Return a random integer between 0 (inclusive) and bound (exclusive)
    }
    // Time Complexity: O(1) — generating a random number is constant time.
    // Space Complexity: O(1) — constant space used by the Random object.

    // 7) How to Print Pattern in Java (Example: Pyramid Pattern)
    // Uses basic loops, available since Java 1.0
    public static void printPattern(int rows) {
        // Outer loop for number of rows
        for (int i = 1; i <= rows; i++) {
            // Print spaces to align the pyramid
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            // Print stars to form the pyramid shape
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after printing one row of the pattern
        }
    }
    // Time Complexity: O(rows^2) — two nested loops.
    // Space Complexity: O(1) — constant space used.

    // 8) How to Compare Two Objects in Java
    // .equals() is available since Java 1.0, supports custom object comparison
    public static boolean compareObjects(Object obj1, Object obj2) {
        return obj1.equals(obj2); // equals() compares the two objects for equality
    }
    // Time Complexity: O(1) — calling equals() is constant time for simple objects.
    // Space Complexity: O(1) — constant space.

    // 9) How to Create Object in Java
    // Object creation syntax available since Java 1.0
    public static void createObjectExample() {
        BasicProgramsJava17 obj = new BasicProgramsJava17(); // Create a new instance of the class
        System.out.println("Object Created: " + obj.toString()); // Print the string representation of the object
    }
    // Time Complexity: O(1) — object creation is constant time.
    // Space Complexity: O(1) — constant space for the object reference.

    // 10) How to Print ASCII Value in Java
    // Casting to int for ASCII values, available since Java 1.0
    public static void printAsciiValue(char ch) {
        int ascii = (int) ch; // Cast the character to an integer to get its ASCII value
        System.out.println("ASCII value of '" + ch + "' is: " + ascii); // Print the ASCII value
    }
    // Time Complexity: O(1) — constant time to cast and print.
    // Space Complexity: O(1) — constant space.

    public static void main(String[] args) {
        // Test Fibonacci Series
        printFibonacci(10);

        // Test Prime Number
        int primeCheck = 29;
        System.out.println(primeCheck + " is prime: " + isPrime(primeCheck));

        // Test Palindrome
        String palindromeTest = "madam";
        System.out.println(palindromeTest + " is palindrome: " + isPalindrome(palindromeTest));

        // Test Factorial
        int factorialTest = 5;
        System.out.println("Factorial of " + factorialTest + " is: " + factorial(factorialTest));

        // Test Armstrong Number
        int armstrongTest = 153;
        System.out.println(armstrongTest + " is Armstrong: " + isArmstrong(armstrongTest));

        // Test Random Number Generation
        int randomNumber = generateRandomNumber(100);
        System.out.println("Random Number: " + randomNumber);

        // Test Pattern Printing
        printPattern(5);

        // Test Object Comparison
        BasicProgramsJava17 obj1 = new BasicProgramsJava17();
        BasicProgramsJava17 obj2 = new BasicProgramsJava17();
        System.out.println("Objects are equal: " + compareObjects(obj1, obj2));

        // Test Object Creation
        createObjectExample();

        // Test ASCII Value Printing
        printAsciiValue('A');
    }
}


