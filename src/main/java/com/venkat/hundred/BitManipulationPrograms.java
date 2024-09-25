package com.venkat.hundred;

public class BitManipulationPrograms {

    // 1. Find the Number of Set Bits in an Integer (Hamming weight)
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;  // Check the least significant bit (if set, increment count)
            n >>= 1;  // Shift the bits to the right (divide by 2)
        }
        return count;  // Return the total count of set bits
    }

    // 2. Check if a Number is a Power of Two
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;  // Negative numbers and zero can't be a power of two
        return (n & (n - 1)) == 0;  // A number that is a power of two has only one set bit
    }

    // 3. Swap Two Numbers using Bitwise XOR
    public static void swapNumbers(int a, int b) {
        System.out.println("Before swap: a = " + a + ", b = " + b);
        a = a ^ b;  // Step 1: a becomes a XOR b
        b = a ^ b;  // Step 2: b becomes (a XOR b) XOR b = a (original a)
        a = a ^ b;  // Step 3: a becomes (a XOR b) XOR a = b (original b)
        System.out.println("After swap: a = " + a + ", b = " + b);
    }

    // 4. Find the Single Non-repeated Element in an Array (XOR Method)
    public static int findSingleElement(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;  // XOR all elements, and the repeated elements will cancel out
        }
        return result;  // The result will be the single non-repeated element
    }

    // 5. Find Two Missing Numbers in an Array using XOR
    public static void findTwoMissingNumbers(int[] arr, int n) {
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;  // XOR all numbers from 1 to n
        }

        for (int num : arr) {
            xor ^= num;  // XOR all numbers in the array
        }

        // Now, xor = missingNumber1 ^ missingNumber2
        // Find the rightmost set bit in xor
        int setBit = xor & ~(xor - 1);

        int missing1 = 0, missing2 = 0;
        // Divide the elements into two groups based on the set bit
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                missing1 ^= i;  // Group with set bit
            } else {
                missing2 ^= i;  // Group without set bit
            }
        }

        for (int num : arr) {
            if ((num & setBit) != 0) {
                missing1 ^= num;  // Group with set bit
            } else {
                missing2 ^= num;  // Group without set bit
            }
        }

        System.out.println("Two missing numbers are: " + missing1 + " and " + missing2);
    }

    public static void main(String[] args) {
        // 1. Count the number of set bits in an integer
        int num1 = 29;  // Binary representation: 11101
        System.out.println("Number of set bits in " + num1 + ": " + countSetBits(num1));
        // Output: Number of set bits in 29: 4

        // 2. Check if a number is a power of two
        int num2 = 16;
        System.out.println(num2 + " is a power of two: " + isPowerOfTwo(num2));
        // Output: 16 is a power of two: true

        int num3 = 18;
        System.out.println(num3 + " is a power of two: " + isPowerOfTwo(num3));
        // Output: 18 is a power of two: false

        // 3. Swap two numbers using XOR
        int a = 5, b = 10;
        swapNumbers(a, b);
        // Output:
        // Before swap: a = 5, b = 10
        // After swap: a = 10, b = 5

        // 4. Find the single non-repeated element in an array
        int[] array = {2, 3, 5, 4, 5, 3, 2};
        System.out.println("Single non-repeated element: " + findSingleElement(array));
        // Output: Single non-repeated element: 4

        // 5. Find two missing numbers in an array
        int[] arrayWithMissing = {1, 2, 4, 6};  // n = 6, missing numbers are 3 and 5
        findTwoMissingNumbers(arrayWithMissing, 6);
        // Output: Two missing numbers are: 3 and 5
    }
}

