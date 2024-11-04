package com.venkat.codility.easy.ArrayAndBasicIteration;

public class OddOccurrencesInArray {
    public static int findOddOccurrence(int[] A) {
        int result = 0;
        // XOR all elements to find the one with an odd occurrence
        for (int num : A) {
            result ^= num;
        }
        return result;
    }
/*
3. Bitwise XOR (^)
The XOR (exclusive OR) operator returns 1 only if the corresponding bits of the operands are different. If both bits are the same, the result is 0.

Example:
java
Copy code
int a = 5;  // Binary: 0101
int b = 3;  // Binary: 0011

int result = a ^ b; // Result: 0110 (Binary) = 6 (Decimal)
System.out.println("a ^ b = " + result); // Output: 6
Explanation:
5 in binary is 0101.
3 in binary is 0011.
Performing 0101 ^ 0011 results in 0110:
Only the positions where the bits differ between a and b are set to 1.
Common Use:
XOR is useful for flipping bits or swapping values without a temporary variable:

java
Copy code
int x = 5, y = 3;
x = x ^ y; // x becomes 6
y = x ^ y; // y becomes 5
x = x ^ y; // x becomes 3
 */
    public static void main(String[] args) {
        int result = findOddOccurrence(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println("Odd Occurrence Element: " + result); // Output: 7
    }
}

