package com.venkat.programs.basic;

import java.util.*;
import java.util.stream.IntStream;
/*
Recursion and basic loops: Available since Java 1.0.
StringBuilder: Available since Java 1.5.
Math.pow(), Math.sqrt(): Available since Java 1.0.
Streams API (IntStream): Introduced in Java 8.
Bitwise XOR (^) for swapping numbers: Available since Java 1.0.
Integer.bitCount(): Available since Java 1.5.
Collections.reverse(): Available since Java 1.2.
 */
public class NumberProgramsJava17 {

    // 1) Reverse a Number in Java
    // Uses basic loop constructs, available since Java 1.0
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    // 2) Convert Number to Word
    // Uses basic array and loop, available since Java 1.0
    public static String numberToWord(int num) {
        String[] words = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        StringBuilder word = new StringBuilder();
        while (num > 0) {
            word.insert(0, words[num % 10] + " ");
            num /= 10;
        }
        return word.toString().trim();
    }

    // 3) Automorphic Number in Java
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return String.valueOf(square).endsWith(String.valueOf(num)); // String methods available since Java 1.0
    }

    // 4) Peterson Number in Java
    public static boolean isPeterson(int num) {
        int original = num, sum = 0;
        while (num > 0) {
            sum += factorial(num % 10);
            num /= 10;
        }
        return sum == original;
    }

    // Helper: Factorial method
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1); // Recursion available since Java 1.0
    }

    // 5) Sunny Number in Java
    public static boolean isSunny(int num) {
        return Math.sqrt(num + 1) % 1 == 0; // Math.sqrt() available since Java 1.0
    }

    // 6) Tech Number in Java
    public static boolean isTech(int num) {
        if (num >= 1000 && num <= 9999) {
            int firstHalf = num / 100;
            int secondHalf = num % 100;
            return Math.pow(firstHalf + secondHalf, 2) == num;
        }
        return false;
    }

    // 7) Fascinating Number in Java
    public static boolean isFascinating(int num) {
        String concatenated = num + "" + num * 2 + num * 3;
        return concatenated.length() == 9 && IntStream.rangeClosed(1, 9).allMatch(i -> concatenated.contains(String.valueOf(i))); // IntStream since Java 8
    }

    // 8) Keith Number in Java
    public static boolean isKeith(int num) {
        List<Integer> sequence = new ArrayList<>();
        int temp = num, digits = String.valueOf(num).length();
        while (temp > 0) {
            sequence.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(sequence); // Collections since Java 1.2
        while (true) {
            int sum = sequence.subList(sequence.size() - digits, sequence.size()).stream().mapToInt(Integer::intValue).sum(); // Stream API since Java 8
            if (sum == num) return true;
            if (sum > num) return false;
            sequence.add(sum);
        }
    }

    // 9) Neon Number in Java
    public static boolean isNeon(int num) {
        int square = num * num, sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    // 10) Spy Number in Java
    public static boolean isSpy(int num) {
        int sum = 0, product = 1;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return sum == product;
    }

    // 11) Simple ATM Program (Deposit, Withdraw, Balance Check)
    public static void atmSimulator() {
        Scanner sc = new Scanner(System.in);
        double balance = 1000; // Default balance
        while (true) {
            System.out.println("Choose an option: 1) Deposit 2) Withdraw 3) Balance 4) Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    System.out.println("New Balance: " + balance);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("New Balance: " + balance);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.println("Balance: " + balance);
                    break;
                case 4:
                    return;
            }
        }
    }

    // 12) Autobiographical Number in Java
    public static boolean isAutobiographical(int num) {
        String str = String.valueOf(num);
        int[] count = new int[10];
        for (char c : str.toCharArray()) count[c - '0']++;
        for (int i = 0; i < str.length(); i++) if (count[i] != str.charAt(i) - '0') return false;
        return true;
    }

    // 13) Emirp Number in Java
    public static boolean isEmirp(int num) {
        return isPrime(num) && isPrime(reverseNumber(num));
    }

    // 14) Sphenic Number in Java
    public static boolean isSphenic(int num) {
        int count = 0, product = 1;
        for (int i = 2; i <= num / 2 && count < 3; i++) {
            if (isPrime(i) && num % i == 0) {
                product *= i;
                count++;
            }
        }
        return count == 3 && product == num;
    }

    // 15) Buzz Number in Java
    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    // 16) Duck Number in Java
    public static boolean isDuck(int num) {
        String str = String.valueOf(num);
        return str.contains("0") && str.charAt(0) != '0';
    }

    // 17) Evil Number in Java
    public static boolean isEvil(int num) {
        return Integer.bitCount(num) % 2 == 0; // Integer.bitCount() available since Java 1.5
    }

    // 18) ISBN Number in Java (10-digit)
    public static boolean isValidISBN(int num) {
        String str = String.valueOf(num);
        if (str.length() != 10) return false;
        int sum = 0;
        for (int i = 0; i < 10; i++) sum += (10 - i) * (str.charAt(i) - '0');
        return sum % 11 == 0;
    }

    // 19) Krishnamurthy Number in Java
    public static boolean isKrishnamurthy(int num) {
        int sum = 0, original = num;
        while (num > 0) {
            sum += factorial(num % 10);
            num /= 10;
        }
        return sum == original;
    }

    // 20) Bouncy Number in Java
    public static boolean isBouncy(int num) {
        boolean increasing = false, decreasing = false;
        int previousDigit = num % 10;
        num /= 10;
        while (num > 0) {
            int currentDigit = num % 10;
            if (currentDigit < previousDigit) increasing = true;
            if (currentDigit > previousDigit) decreasing = true;
            if (increasing && decreasing) return true;
            previousDigit = currentDigit;
            num /= 10;
        }
        return false;
    }

    // 21) Mystery Number in Java
    public static boolean isMystery(int num) {
        for (int i = 1; i < num / 2; i++) if (i + reverseNumber(i) == num) return true;
        return false;
    }

    // 22) Smith Number in Java
    public static boolean isSmith(int num) {
        if (isPrime(num)) return false;
        return sumDigits(num) == sumPrimeFactorDigits(num);
    }

    // Helper method for Smith Number
    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int sumPrimeFactorDigits(int num) {
        int sum = 0;
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                sum += sumDigits(i);
                num /= i;
            }
        }
        return sum;
    }

    // 23) Strontio Number in Java
    public static boolean isStrontio(int num) {
        int doubled = num * 2;
        int tens = (doubled / 10) % 10;
        int hundreds = (doubled / 100) % 10;
        return tens == hundreds;
    }

    // 24) Xylem and Phloem Number in Java
    public static boolean isXylemPhloem(int num) {
        int firstDigit = num / 10000;
        int lastDigit = num % 10;
        int middleSum = 0;
        num = num / 10 % 1000;
        while (num > 0) {
            middleSum += num % 10;
            num /= 10;
        }
        return firstDigit + lastDigit == middleSum;
    }

    // 25) nth Prime Number in Java
    public static int findNthPrime(int n) {
        int count = 0, num = 2;
        while (true) {
            if (isPrime(num)) count++;
            if (count == n) return num;
            num++;
        }
    }

    // 26) Display Alternate Prime Numbers
    public static void displayAlternatePrimes(int limit) {
        int count = 0;
        for (int i = 2; count < limit; i++) {
            if (isPrime(i) && count % 2 == 0) System.out.print(i + " ");
            count++;
        }
        System.out.println();
    }

    // Helper: Prime check method
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) if (num % i == 0) return false;
        return true;
    }

    // 27) Find Square Root Without sqrt() Method
    public static double findSquareRoot(double num) {
        double temp;
        double sqrt = num / 2;
        do {
            temp = sqrt;
            sqrt = (temp + (num / temp)) / 2;
        } while ((temp - sqrt) != 0);
        return sqrt;
    }

    // 28) Swap Two Numbers Using Bitwise Operator
    public static void swapNumbersBitwise(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Swapped Numbers: a = " + a + ", b = " + b);
    }

    // 29) Find GCD of Two Numbers
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 30) Find Largest of Three Numbers
    public static int findLargestOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)); // Math.max() available since Java 1.0
    }

    // 31) Find Smallest of Three Numbers Using Ternary Operator
    public static int findSmallestOfThree(int a, int b, int c) {
        return (a < b) ? (a < c ? a : c) : (b < c ? b : c); // Ternary operator since Java 1.0
    }

    // 32) Check if Number is Positive or Negative
    public static void checkPositiveOrNegative(int num) {
        if (num > 0) System.out.println(num + " is Positive.");
        else if (num < 0) System.out.println(num + " is Negative.");
        else System.out.println(num + " is Zero.");
    }

    // 33) Check if a Number is Perfect Square
    public static boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num); // Math.sqrt() since Java 1.0
        return sqrt == Math.floor(sqrt);
    }

    // 34) Display Even Numbers From 1 to 100
    public static void displayEvenNumbers() {
        for (int i = 2; i <= 100; i += 2) System.out.print(i + " ");
        System.out.println();
    }

    // 35) Display Odd Numbers From 1 to 100
    public static void displayOddNumbers() {
        for (int i = 1; i <= 100; i += 2) System.out.print(i + " ");
        System.out.println();
    }

    // 36) Find Sum of Natural Numbers
    public static int sumOfNaturalNumbers(int n) {
        return n * (n + 1) / 2; // Formula for sum of first n natural numbers, available since Java 1.0
    }

    public static void main(String[] args) {
        // Example Test Cases
        System.out.println("Reverse of 1234: " + reverseNumber(1234));
        System.out.println("Number to Word: " + numberToWord(1234));
        System.out.println("Is Automorphic: " + isAutomorphic(25));
        atmSimulator(); // Test for ATM program
        System.out.println("GCD of 54 and 24: " + findGCD(54, 24));
        displayEvenNumbers();
    }
}

