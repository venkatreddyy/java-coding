package com.venkat.programs.basic;

import java.util.Random;

public class BasicProgramsJava17 {

    // 1) Fibonacci Series in Java
    // Uses basic loop constructs available since Java 1.0
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b);
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
        System.out.println();
    }

    // 2) Prime Number Program in Java
    // Uses basic loops and math, available since Java 1.0
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) { // Math.sqrt() available since Java 1.0
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 3) Palindrome Program in Java
    // StringBuilder introduced in Java 1.5
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString(); // StringBuilder.reverse() since Java 1.5
        return str.equals(reversed);
    }

    // 4) Factorial Program in Java
    // Uses recursion, available since Java 1.0
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 5) Armstrong Number in Java
    // Math.pow() available since Java 1.0
    public static boolean isArmstrong(int num) {
        int original = num, sum = 0, digits = String.valueOf(num).length(); // String.valueOf() since Java 1.0
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits); // Math.pow() since Java 1.0
            num /= 10;
        }
        return sum == original;
    }

    // 6) How to Generate Random Number in Java
    // Random class introduced in Java 1.0, nextInt() since Java 1.2
    public static int generateRandomNumber(int bound) {
        Random random = new Random(); // Random class available since Java 1.0
        return random.nextInt(bound); // nextInt() available since Java 1.2
    }

    // 7) How to Print Pattern in Java (Example: Pyramid Pattern)
    // Uses basic loops, available since Java 1.0
    public static void printPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 8) How to Compare Two Objects in Java
    // .equals() is available since Java 1.0, supports custom object comparison
    public static boolean compareObjects(Object obj1, Object obj2) {
        return obj1.equals(obj2); // equals() available since Java 1.0
    }

    // 9) How to Create Object in Java
    // Object creation syntax available since Java 1.0
    public static void createObjectExample() {
        BasicProgramsJava17 obj = new BasicProgramsJava17(); // Object creation syntax since Java 1.0
        System.out.println("Object Created: " + obj.toString()); // toString() since Java 1.0
    }

    // 10) How to Print ASCII Value in Java
    // Casting to int for ASCII values, available since Java 1.0
    public static void printAsciiValue(char ch) {
        int ascii = (int) ch; // Casting to int since Java 1.0
        System.out.println("ASCII value of '" + ch + "' is: " + ascii);
    }

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

