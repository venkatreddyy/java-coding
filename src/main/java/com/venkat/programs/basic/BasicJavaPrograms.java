package com.venkat.programs.basic;

import java.util.Random;
/*
Fibonacci Series: Generates the first n numbers of the Fibonacci sequence.
Prime Number Check: Determines whether a given number is prime.
Palindrome Check: Checks if a string is a palindrome.
Factorial: Recursively calculates the factorial of a number.
Armstrong Number: Checks if a number is an Armstrong number.
Random Number Generation: Generates a random number using the Random class.
Pattern Printing: Prints a pyramid pattern using *.
Object Comparison: Compares two objects using .equals().
Object Creation: Demonstrates object creation in Java.
ASCII Value Printing: Prints the ASCII value of a given character.
 */

public class BasicJavaPrograms {

    // 1) Fibonacci Series in Java (without using additional libraries)
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

    // 2) Prime Number Program in Java (without built-in Math functions)
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 3) Palindrome Program in Java (without StringBuilder)
    public static boolean isPalindrome(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 4) Factorial Program in Java (Recursive with custom logic)
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 5) Armstrong Number in Java (without using Math.pow)
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        int digits = countDigits(num);
        while (num > 0) {
            int digit = num % 10;
            sum += customPower(digit, digits);
            num /= 10;
        }
        return sum == original;
    }

    // Helper method to calculate power manually (replaces Math.pow)
    public static int customPower(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // Helper method to count the number of digits in a number
    public static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    // 6) Random Number Generation in Java (without using Random class)
    public static int generateRandomNumber(int bound) {
        long currentTimeMillis = System.currentTimeMillis();
        int seed = (int) (currentTimeMillis % 10000);
        seed = (seed * 9301 + 49297) % 233280;
        return seed % bound;
    }

    // 7) How to Print Pattern in Java (Example: Pyramid Pattern)
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

    // 8) How to Compare Two Objects in Java (without using .equals())
    public static boolean compareObjects(BasicJavaPrograms obj1, BasicJavaPrograms obj2) {
        return obj1 == obj2; // Comparison by reference
    }

    // 9) How to Create Object in Java (custom object creation)
    public static void createObjectExample() {
        BasicJavaPrograms obj = new BasicJavaPrograms();
        System.out.println("Object Created: " + obj.toString());
    }

    // 10) How to Print ASCII Value in Java (without using casting)
    public static void printAsciiValue(char ch) {
        int ascii = getAsciiValue(ch);
        System.out.println("ASCII value of '" + ch + "' is: " + ascii);
    }

    // Helper method to get ASCII value manually
    public static int getAsciiValue(char ch) {
        return (int) ch; // Custom implementation is not required here; this casting is appropriate.
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
        BasicJavaPrograms obj1 = new BasicJavaPrograms();
        BasicJavaPrograms obj2 = new BasicJavaPrograms();
        System.out.println("Objects are equal: " + compareObjects(obj1, obj2));

        // Test Object Creation
        createObjectExample();

        // Test ASCII Value Printing
        printAsciiValue('A');
    }
}

