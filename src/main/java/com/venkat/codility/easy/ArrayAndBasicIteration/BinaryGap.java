package com.venkat.codility.easy.ArrayAndBasicIteration;

/*

Problem: Find the longest sequence of consecutive zeros surrounded by ones in a binary representation of a number.
Algorithm: Convert the number to binary, then iterate to find the longest sequence of 0s between 1s.
Solution: Traverse the binary string, updating the maximum gap length when a closing 1 is encountered.

Description:
Given a positive integer N, find the length of its longest binary gap. A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example:

Given N = 1041, the binary representation is 10000010001, which contains two gaps of lengths 5 and 3. The longest gap is 5.
Given N = 32, the binary representation is 100000, which has no binary gaps, so the result should be 0.
Constraints:
N is a positive integer.
Pattern:
This problem can be approached using string manipulation:

Convert the integer to a binary string.
Use a loop to traverse the binary representation and keep track of the length of the gaps.
Whenever a '1' is encountered, update the maximum gap length.
Algorithm:
Convert N to its binary representation using Integer.toBinaryString(N).
Initialize two variables: maxGap to store the maximum gap found and currentGap to count the zeros in the current gap.
Traverse the binary string:
If a '1' is found:
Update maxGap if currentGap is greater than maxGap.
Reset currentGap to 0 (indicating the start of a new gap).
If a '0' is found, increment currentGap.
After looping through the string, return maxGap.



Explanation of Code:
Binary Conversion: Integer.toBinaryString(N) converts the integer N into its binary string representation.
Loop Through Binary String:
The loop iterates over each character in the binary string.
If the character is '1':
We check if we're in a gap (inGap is true). If so, we update maxGap with the length of currentGap.
Reset currentGap to 0 to start counting the next potential gap.
Set inGap to true.
If the character is '0' and inGap is true, increment currentGap.
Result: After the loop finishes, maxGap holds the length of the longest binary gap.
Example Walkthrough:
For N = 1041:

Binary Representation: 10000010001
Traverse each bit:
1: Start of a gap.
0, 0, 0, 0, 0: Increment currentGap for each 0, making currentGap = 5.
1: End of the first gap. maxGap = 5.
0, 0, 0: Increment currentGap again, making currentGap = 3.
1: End of the second gap. maxGap remains 5.
Result: The longest gap is 5.
For N = 32:

Binary Representation: 100000
No gaps surrounded by '1's, so maxGap remains 0.
Complexity Analysis:
Time Complexity: O(log N), as converting an integer N to binary takes O(log N) bits, and we traverse each bit once.
Space Complexity: O(log N) for storing the binary representation in the string.
This solution efficiently finds the longest binary gap by focusing on counting sequences of zeros between ones in the binary representation of the given integer N.
 */
public class BinaryGap {
    public static int findBinaryGap(int N) {
        // Convert the integer to binary representation
        String binary = Integer.toBinaryString(N);
        // Split the binary string at each "1" to get sequences of zeros
        String[] gaps = binary.split("1");
        for(String gap :gaps) {
            System.out.println("string gaps "+gap);
        }
        int maxGap = 0;
        for (int i = 0; i < gaps.length - 1; i++) {
            // Find the longest sequence of zeros
            //(a >= b) ? a : b;
            maxGap = Math.max(maxGap, gaps[i].length());
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int result = findBinaryGap(529); // Example input
        System.out.println("Binary Gap: " + result); // Output: 4
    }
}

